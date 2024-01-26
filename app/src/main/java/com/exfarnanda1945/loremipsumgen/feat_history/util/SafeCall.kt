package com.exfarnanda1945.loremipsumgen.feat_history.util

import com.exfarnanda1945.loremipsumgen.core.utils.Resource

object SafeCall {
    inline operator fun <T> invoke(call: () -> T):Resource<T>{
        return try {
            val result = call.invoke()
            Resource.success(result)
        } catch (e: Exception) {
            Resource.failure(e.localizedMessage ?: "Unknown Error Occurred")
        }
    }
}