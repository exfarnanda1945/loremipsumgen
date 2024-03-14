package com.exfarnanda1945.loremipsumgen.core.utils

import com.google.gson.Gson
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class JsonUtils @Inject constructor(val gson: Gson) {
    inline fun <reified T> toJson(data: T): String = gson.toJson(data)

    inline fun <reified T> fromJson(value: String): T = gson.fromJson(value, T::class.java)
}