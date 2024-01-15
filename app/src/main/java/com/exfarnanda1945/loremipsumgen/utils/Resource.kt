package com.exfarnanda1945.loremipsumgen.utils

data class Resource<T>(val data: T?, val message: String = "") {
    companion object {
        fun <T> success(data: T): Resource<T> = Resource(data)
        fun <T> failure(message: String): Resource<T> = Resource(null, message)
    }
}
