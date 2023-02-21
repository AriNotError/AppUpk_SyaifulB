package com.example.appupk_syaifulbahri.Balok

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

class Balok : AppCompatActivity() {

    private lateinit var panjang : EditText
    private lateinit var lebar : EditText
    private lateinit var tinggi : EditText
    private lateinit var luas : RadioButton
    private lateinit var volume : RadioButton
    private lateinit var hitung : Button
    private lateinit var hasil : TextView

    private var rumus : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_balok)

        panjang = findViewById(R.id.panjang)
        lebar = findViewById(R.id.lebar)
        tinggi = findViewById(R.id.tinggi)
        luas = findViewById(R.id.luas)
        volume = findViewById(R.id.volume)
        hasil = findViewById(R.id.hasil)
        hitung = findViewById(R.id.hitung)

        hitung.setOnClickListener {
            var panjang = panjang.text.toString().toInt()
            var lebar = lebar.text.toString().toInt()
            var tinggi = tinggi.text.toString().toInt()
            if(luas.isChecked){
                rumus = ( 2 * ((panjang * lebar) + (panjang * tinggi) + (lebar * tinggi)))
                hasil.setText(rumus.toString())
            } else {
                rumus = (panjang * lebar * tinggi)
                hasil.setText(rumus.toString())
            }
        }

    }

    fun backToMenu(view: View){
        val pindah = Intent (this, Menu::class.java)
        startActivity(pindah)
    }

}