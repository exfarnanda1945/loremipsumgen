package com.exfarnanda1945.loremipsumgen.core.utils

object SafeCall {
    inline operator fun <T> invoke(call: () -> T): Resource<T> {
        return try {
            val result = call.invoke()
            Resource.Success(result)
        } catch (e: Exception) {
            Resource.Failure(e.localizedMessage ?: "Unknown Error Occurred")
        }
    }
}