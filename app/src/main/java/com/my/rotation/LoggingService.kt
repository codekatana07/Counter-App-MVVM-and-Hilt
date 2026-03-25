package com.my.rotation

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.util.Log
import androidx.core.os.postDelayed

class LoggingService : Service() {

    val handler: Handler = Handler( Looper.getMainLooper())

    val runnable = Runnable{
        Log.d("My_Tag","runnable is executed")
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("My_Tag","${this::class.simpleName} is created")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        //stopSelf()
        Log.d("My_Tag","${LoggingService::class.simpleName} is started")
        handler.postDelayed(runnable,10000)
        //return super.onStartCommand(intent, flags, startId)
        return START_STICKY
    }

    override fun onDestroy() {

        Log.d("My_Tag","${LoggingService::class.simpleName} is destroyed")
        super.onDestroy()
    }
}