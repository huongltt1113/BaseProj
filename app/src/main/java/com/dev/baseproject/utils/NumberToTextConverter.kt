package com.dev.baseproject.utils

object NumberToTextConverter {
    private val numberMaps = mapOf(
        "en" to mapOf(
            "0" to "zero", "1" to "one", "2" to "two", "3" to "three", "4" to "four",
            "5" to "five", "6" to "six", "7" to "seven", "8" to "eight", "9" to "nine"
        ),
        "de" to mapOf(
            "0" to "null", "1" to "eins", "2" to "zwei", "3" to "drei", "4" to "vier",
            "5" to "fünf", "6" to "sechs", "7" to "sieben", "8" to "acht", "9" to "neun"
        ),
        "hi" to mapOf(
            "0" to "शून्य", "1" to "एक", "2" to "दो", "3" to "तीन", "4" to "चार",
            "5" to "पांच", "6" to "छह", "7" to "सात", "8" to "आठ", "9" to "नौ"
        ),
        "ru" to mapOf(
            "0" to "ноль", "1" to "один", "2" to "два", "3" to "три", "4" to "четыре",
            "5" to "пять", "6" to "шесть", "7" to "семь", "8" to "восемь", "9" to "девять"
        ),
        "ko" to mapOf(
            "0" to "영", "1" to "일", "2" to "이", "3" to "삼", "4" to "사",
            "5" to "오", "6" to "육", "7" to "칠", "8" to "팔", "9" to "구"
        ),
        "pt" to mapOf(
            "0" to "zero", "1" to "um", "2" to "dois", "3" to "três", "4" to "quatro",
            "5" to "cinco", "6" to "seis", "7" to "sete", "8" to "oito", "9" to "nove"
        ),
        "es" to mapOf(
            "0" to "cero", "1" to "uno", "2" to "dos", "3" to "tres", "4" to "cuatro",
            "5" to "cinco", "6" to "seis", "7" to "siete", "8" to "ocho", "9" to "nueve"
        ),
        "zh" to mapOf(
            "0" to "零", "1" to "一", "2" to "二", "3" to "三", "4" to "四",
            "5" to "五", "6" to "六", "7" to "七", "8" to "八", "9" to "九"
        ),
        "ar" to mapOf(
            "0" to "صفر", "1" to "واحد", "2" to "اثنان", "3" to "ثلاثة", "4" to "أربعة",
            "5" to "خمسة", "6" to "ستة", "7" to "سبعة", "8" to "ثمانية", "9" to "تسعة"
        ),
        "vi" to mapOf(
            "0" to "không", "1" to "một", "2" to "hai", "3" to "ba", "4" to "bốn",
            "5" to "năm", "6" to "sáu", "7" to "bảy", "8" to "tám", "9" to "chín"
        ),
        "uk" to mapOf(
            "0" to "нуль", "1" to "один", "2" to "два", "3" to "три", "4" to "чотири",
            "5" to "п'ять", "6" to "шість", "7" to "сім", "8" to "вісім", "9" to "дев'ять"
        ),
        "ja" to mapOf(
            "0" to "零", "1" to "一", "2" to "二", "3" to "三", "4" to "四",
            "5" to "五", "6" to "六", "7" to "七", "8" to "八", "9" to "九"
        ),
        "tr" to mapOf(
            "0" to "sıfır", "1" to "bir", "2" to "iki", "3" to "üç", "4" to "dört",
            "5" to "beş", "6" to "altı", "7" to "yedi", "8" to "sekiz", "9" to "dokuz"
        )
    )

    /**
     * Convert a number to its text representation in the specified locale
     */
    fun numberToText(number: String, locale: String): String {
        val localeMap = numberMaps[locale] ?: numberMaps["en"]!! // fallback to English
        return number.map { digit ->
            localeMap[digit.toString()] ?: digit.toString()
        }.joinToString(" ")
    }

    /**
     * Convert a string containing numbers to a string with text representations
     */
    @JvmStatic
    fun convertNumbersInText(text: String, locale: String): String {
        val numberPattern = Regex("\\d+")
        return numberPattern.replace(text) { matchResult ->
            numberToText(matchResult.value, locale)
        }
    }
}