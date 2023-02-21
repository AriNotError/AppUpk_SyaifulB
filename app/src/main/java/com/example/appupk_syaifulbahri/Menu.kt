package com.example.appupk_syaifulbahri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.appupk_syaifulbahri.Balok.Balok
import com.example.appupk_syaifulbahri.Kubus.Kubus
import com.example.appupk_syaifulbahri.Persegi.Persegi
import com.example.appupk_syaifulbahri.PersegiPanjang.PersegiPanjang

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }

    fun backToPertama(view: View){
        val pindah = Intent (this, MainActivity::class.java)
        startActivity(pindah)
    }

    fun toPersegi(view: View){
        val pindah = Intent (this, Persegi::class.java)
        startActivity(pindah)
    }

    fun toPersegiPanjang(view: View){
        val pindah = Intent (this, PersegiPanjang::class.java)
        startActivity(pindah)
    }

    fun toBalok(view: View){
        val pindah = Intent (this, Balok::class.java)
        startActivity(pindah)
    }

    fun toKubus(view: View){
        val pindah = Intent (this, Kubus::class.java)
        startActivity(pindah)
    }

    fun ToRumus(view: View){
        val pindah = Intent (this, Rumus::class.java)
        startActivity(pindah)
    }

}