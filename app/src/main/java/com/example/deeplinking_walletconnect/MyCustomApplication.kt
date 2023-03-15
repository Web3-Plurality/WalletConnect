package com.example.deeplinking_walletconnect

import android.app.Application
import android.content.Intent
import android.content.res.Configuration
import android.util.Log
import androidx.core.net.toUri
import com.walletconnect.android.Core
import com.walletconnect.android.CoreClient
import com.walletconnect.android.relay.ConnectionType
import com.walletconnect.auth.client.Auth
import com.walletconnect.auth.client.AuthClient
import com.walletconnect.sign.client.Sign
import com.walletconnect.sign.client.SignClient
import timber.log.Timber.Forest.tag

class MyCustomApplication : Application() {
    // Called when the application is starting, before any other application objects have been created.
    // Overriding this method is totally optional!
    override fun onCreate() {
        super.onCreate()

        // Required initialization logic here!
        val projectId = "e33c836025414510b9efa4b11224ab85" //Get Project ID at https://cloud.walletconnect.com/
        val relayUrl = "relay.walletconnect.com"
        val serverUrl = "wss://$relayUrl?projectId=$projectId"
        val connectionType = ConnectionType.AUTOMATIC // or ConnectionType.MANUAL

        val appMetaData = Core.Model.AppMetaData(
            name = "Plurality",
            description = "Kotlin App",
            url = "Plurality url",
            icons = listOf("https://gblobscdn.gitbook.com/spaces%2F-LJJeCjcLrr53DcT1Ml7%2Favatar.png?alt=media"),
            redirect = getString(R.string.deep_link_url)  // Custom Redirect URI
        )

        CoreClient.initialize(
            relayServerUrl = serverUrl,
            connectionType = connectionType,
            application = this,
            metaData = appMetaData
        ) { error -> Log.e("CoreClient_Initialization_Error", error.throwable.stackTraceToString()) }

        val init = Sign.Params.Init(core = CoreClient)
        SignClient.initialize(init) { error ->
            Log.e("SignClient_Initialization_Error", error.throwable.stackTraceToString())
        }
    }

    // Called by the system when the device configuration changes while your component is running.
    // Overriding this method is totally optional!
    override fun onConfigurationChanged ( newConfig : Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    // This is called when the overall system is running low on memory,
    // and would like actively running processes to tighten their belts.
    // Overriding this method is totally optional!
    override fun onLowMemory() {
        super.onLowMemory()
    }
}
