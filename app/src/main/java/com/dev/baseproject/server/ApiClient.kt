package com.dev.baseproject.server

import com.dev.baseproject.data.JsonSetting
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiClient {

    @GET
    suspend fun getStringSuspend(@Url url: String): Response<String>

    @GET
    suspend fun getConfigFromHosting(@Url url: String): Response<JsonSetting>

}