package com.exfarnanda1945.loremipsumgen.utils

sealed class ConnectionState{
    object Available:ConnectionState()
    object Unavailable:ConnectionState()
}