package com.my.rotation

import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.my.rotation.databinding.Activity2Binding

class Activity2 : AppCompatActivity() {
    private lateinit var binding: Activity2Binding
    lateinit var wifiReceiver: wifiReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)

         wifiReceiver= wifiReceiver()
        this.registerReceiver(wifiReceiver, IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION))

        val extradata= intent.extras
        val num = extradata?.getInt("count") ?:0
        binding.taxtAct2.text= "count: $num"
    }

    override fun onDestroy() {

        Log.d("My_Tag","OnDestroy() called for activity2")
        //val wifiReceiver = wifiReceiver()
        this.unregisterReceiver(wifiReceiver)
        super.onDestroy()
    }
}