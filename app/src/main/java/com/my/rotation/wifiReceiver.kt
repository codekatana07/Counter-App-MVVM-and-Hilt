 package com.my.rotation

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager
import android.util.Log

 class wifiReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
         if(intent.action.equals(WifiManager.WIFI_STATE_CHANGED_ACTION)) {
            val wifistate=intent.getIntExtra(
                WifiManager.EXTRA_WIFI_STATE,
                WifiManager.WIFI_STATE_UNKNOWN
            )

             when(wifistate){
                 WifiManager.WIFI_STATE_ENABLED ->{
                     Log.d("My_Tag","Wifi state is enabled")
                 }

                 WifiManager.WIFI_STATE_DISABLED->{
                     Log.d("My_Tag","Wifi state is disabled")
                 }

                 else->{
                     Log.d("My_Tag","Wifi state is $wifistate")
                 }
             }
         }
    }
}