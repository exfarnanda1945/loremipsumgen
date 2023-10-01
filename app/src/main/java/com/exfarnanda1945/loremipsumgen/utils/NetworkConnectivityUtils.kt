package com.exfarnanda1945.loremipsumgen.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow

val Context.currentConnectionState: ConnectionState
    get() {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return getCurrentConnectivityState(connectivityManager)
    }

fun getCurrentConnectivityState(connectivityManager: ConnectivityManager): ConnectionState {
    val network = connectivityManager.activeNetwork ?: return ConnectionState.Unavailable
    val networkCap =
        connectivityManager.getNetworkCapabilities(network) ?: return ConnectionState.Unavailable

    val connected = networkCap.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)

    return if (connected) ConnectionState.Available else ConnectionState.Unavailable
}


fun networkCallback(callback: (ConnectionState) -> Unit): ConnectivityManager.NetworkCallback {
    return object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            super.onAvailable(network)
            callback(ConnectionState.Available)
        }

        override fun onLost(network: Network) {
            super.onLost(network)
            callback(ConnectionState.Unavailable)
        }
    }
}

fun Context.observeConnectivityAsFlow() = callbackFlow {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    val callback = networkCallback {
        trySend(it)
    }

    val networkRequest = NetworkRequest.Builder()
        .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        .build()

    connectivityManager.registerNetworkCallback(networkRequest, callback)

    trySend(getCurrentConnectivityState(connectivityManager))

    awaitClose {
        connectivityManager.unregisterNetworkCallback(callback)
    }
}
