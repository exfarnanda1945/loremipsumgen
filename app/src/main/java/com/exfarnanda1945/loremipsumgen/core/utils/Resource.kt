package com.exfarnanda1945.loremipsumgen.core.utils

data class Resource<T>(val isSuccess: Boolean, val data: T?, val message: String = "") {
    companion object {
        fun <T> success(data: T): Resource<T> = Resource(true, data)
        fun <T> failure(message: String): Resource<T> = Resource(false, null, message)
    }
}
