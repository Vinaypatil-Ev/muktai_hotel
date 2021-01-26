package com.ev.muktaibank

import android.app.LauncherActivity
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        t1.setOnClickListener(View.OnClickListener {
            launchActivity("menu")
        })
        t2.setOnClickListener(View.OnClickListener {
            launchActivity("your_order")
        })

        t3.setOnClickListener(View.OnClickListener {
            launchActivity("services")
        })

        t4.setOnClickListener(View.OnClickListener {
            launchActivity("hall_book")
        })

    }

    fun launchActivity(type:String){
        val intent = Intent(this, menu::class.java)
        intent.putExtra("type", type)
        startActivity(intent)
    }

}