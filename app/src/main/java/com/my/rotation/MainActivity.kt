package com.my.rotation

import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.net.wifi.WifiManager
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.my.rotation.databinding.ActivityMainBinding
import androidx.core.net.toUri

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var count = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)

        if(savedInstanceState!=null){
            count = savedInstanceState.getInt("count")
            binding.text1.text = count.toString()
        }



        binding.but1.setOnClickListener{
            count++
            binding.text1.text=count.toString()

        }

        binding.but2.setOnClickListener {
            val intent = Intent(this, Activity2::class.java)
            intent.putExtra("count", count)
            this.startActivity(intent)
        }

        binding.but3.setOnClickListener {
            val website = "https://www.youtube.com"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = website.toUri()
           // intent.setData(Uri.parse(website))
            this.startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count",count)
    }

//    override fun onDestroy() {
//
//        super.onDestroy()
//    }
}