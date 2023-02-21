package com.example.appupk_syaifulbahri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun toMenu(view: View){
        val pindah = Intent (this, Menu::class.java)
        startActivity(pindah)
    }

}