package com.dev.baseproject.di

import com.dev.baseproject.BuildConfig
import com.dev.baseproject.data.ErrorResponse
import com.dev.baseproject.local.LocalStorage
import com.dev.baseproject.server.ApiClient
import com.dev.baseproject.server.Network
import com.dev.baseproject.server.NetworkConnectivity
import com.dev.baseproject.utils.ConfigAppUtils
import com.dev.baseproject.utils.Constants
import com.dev.baseproject.utils.Logger
import com.dev.baseproject.utils.NetworkUtils
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.schedulers.Schedulers
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {
    const val TIME_OUT: Long = 30_000
    const val EXPIRED_TIME_CACHE: Long = 1 * 1000 * 3600 * 24 // 1 DAYS
    private val userAgent = "TPcom/3.0 " + System.getProperty("http.agent")

    @Provides
    @Singleton
    fun provideNetworkConnectivity(netWork: Network): NetworkConnectivity = netWork

    @Provides
    @Singleton
    fun providePostApi(retrofit: Retrofit): ApiClient {
        return retrofit.create(ApiClient::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofitInterface(httpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().client(httpClient).baseUrl(ConfigAppUtils.SERVER)
//            .addConverterFactory(MoshiConverterFactory.create(getMoshi()).asLenient())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
    }

    @Provides
    fun provideOkHttpClient(
        interceptor: HttpLoggingInterceptor, request: Interceptor
    ): OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).addInterceptor(request)
        .followRedirects(true).connectTimeout(TIME_OUT, TimeUnit.SECONDS)
        .callTimeout(TIME_OUT, TimeUnit.SECONDS).build()

    @Provides
    fun provideLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
    }

    @Provides
    fun listenerResponse(storage: LocalStorage?) = Interceptor { chain ->
        var request = chain.request()
        val build = request.newBuilder().header("Content-Type", "application/json")
            .header("User-Agent", userAgent).header("appId", "").header("deviceId", "")
            .header("mobileId", "")

        val authorization = storage?.authorization
        if (authorization != null) {
            build.header("Authorization", authorization)
        }
        val url = request.url
        val stringUrl = url.toString()
        if (stringUrl.contains("=")) {
//                build.url(stringUrl + "&lowdevice=" + AppConfig.isLowMemory)
        }
        request = build.build()
        val host = url.host
        try {
            var check = true
            val paramExpired =
                url.queryParameter(Constants.EXPIRED)?.toLong()?.also { check = it > 0 }
            var id = ""
            val response = connect(chain, request, storage)
            response
        } catch (e: Exception) {
            //TODO
            Logger.d("------Exception", e.message)
            getErrorResponse(request)
        } catch (e: Error) {
            //TODO
            getErrorResponse(request)
        }
    }

    private fun getMoshi(): Moshi {
        return Moshi.Builder().build()
    }

    private fun connect(
        chain: Interceptor.Chain, request: Request, localStorage: LocalStorage?
    ): Response {
        var errorr: Exception? = null
        var time = System.currentTimeMillis()
        val rawUrl = request.url
        val url = rawUrl.toString()
        try {
            val res = chain.withConnectTimeout(TIME_OUT.toInt() ushr 1, TimeUnit.MILLISECONDS)
                .proceed(request)
            if (res.isSuccessful) {
                val delta = System.currentTimeMillis() - time
                return res
            }
        } catch (e: Exception) {
            errorr = e
        }
        val hasNetwork = NetworkUtils.isNetworkConnected()
        val message = errorr?.message?.lowercase(Locale.getDefault()) ?: ""
        if (!hasNetwork || message.contains("canceled")) {
            //TODO
            throw ErrorResponse(
                code = -1, message = message, cause = errorr?.cause, isOnline = hasNetwork
            ).also {
                it.stackTrace = errorr?.stackTrace ?: arrayOf()
            }
        } else {
            val newUrl = getFailedDomain(url, localStorage)
            if (!newUrl.isNullOrEmpty()) {
                time = System.currentTimeMillis()
                val res = chain.withConnectTimeout(TIME_OUT.toInt() ushr 1, TimeUnit.MILLISECONDS)
                    .proceed(request.newBuilder().url(newUrl).build())
                if (BuildConfig.DEBUG) Logger.d(
                    "OkHttp", "retry api old url = $url ;  new url = $newUrl"
                )
                val delta = System.currentTimeMillis() - time
                return res
            } else throw ErrorResponse(
                code = -1,
                message = message,
                cause = errorr?.cause,
                isOnline = hasNetwork,
                url = url
            )
        }
    }

    private fun getFailedDomain(url: String, localStorage: LocalStorage?): String? {
        when {
            url.contains("rest/") -> {
                return ""
            }

            url.contains("wallpaper/restcache/") -> {
                return ""
            }
        }
        return null
    }

    private fun getCachedResponse(cachedData: String, request: Request): Response {
        return Response.Builder().code(200)
            .body(ResponseBody.create("application/json".toMediaTypeOrNull(), cachedData))
            .message("Response").addHeader("Content-Type", "application/json").request(request)
            .protocol(Protocol.HTTP_2).build()
    }

    fun getErrorResponse(request: Request): Response {
        return Response.Builder().code(200).body("".toResponseBody(null)).message("Empty Response")
            .addHeader("Content-Type", "application/json").request(request)
            .protocol(Protocol.HTTP_2).build()
    }

    fun get(url: String, response: ((String) -> Unit), failure: ((Int) -> Unit)? = null) {
        val request = Request.Builder().url(url).addHeader("user-agent", userAgent).build()
        val client = provideOkHttpClient(provideLoggingInterceptor(), listenerResponse(null))
        client.newCall(request).enqueue(object : Callback {

            override fun onFailure(call: Call, e: IOException) {
                failure?.invoke(-1)
            }

            override fun onResponse(call: Call, res: Response) {
                val code = res.code
                val body = res.body
                if (res.isSuccessful && body != null) {
                    response.invoke(body.string())
                } else {
                    failure?.invoke(code)
                }
            }
        })
    }

}