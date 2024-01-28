package com.exfarnanda1945.loremipsumgen.core.utils

sealed class Resource<T>(
    val data: T? = null,
    val message: String = "",
) {
    class Success<T>(data: T) : Resource<T>(data)
    class Failure<T>(message: String, data: T? = null) : Resource<T>(data, message)
    class Loading<T> : Resource<T>()
}
