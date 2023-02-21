package com.example.appupk_syaifulbahri.Kubus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import com.example.appupk_syaifulbahri.Menu
import com.example.appupk_syaifulbahri.R

class Kubus : AppCompatActivity() {

    private lateinit var sisi : EditText
    private lateinit var luas : RadioButton
    private lateinit var volume : RadioButton
    private lateinit var hitung : Button
    private lateinit var hasil : TextView

    private var rumus : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kubus)

        sisi = findViewById(R.id.sisi)
        luas = findViewById(R.id.luas)
        volume = findViewById(R.id.volume)
        hitung = findViewById(R.id.hitung)
        hasil = findViewById(R.id.hasil)

        hitung.setOnClickListener {
            val sisi = sisi.text.toString().toInt()

            if(luas.isChecked){
                rumus = (6 * (sisi * sisi))
                hasil.setText(rumus.toString())
            } else {
                rumus = (sisi * sisi * sisi)
                hasil.setText(rumus.toString())
            }
        }

    }

    fun backToMenu(view: View){
        val pindah = Intent (this, Menu::class.java)
        startActivity(pindah)
    }

}