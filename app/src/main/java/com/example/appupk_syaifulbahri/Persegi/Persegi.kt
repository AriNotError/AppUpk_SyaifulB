package com.example.appupk_syaifulbahri.Persegi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appupk_syaifulbahri.MainActivity
import com.example.appupk_syaifulbahri.Menu
import com.example.appupk_syaifulbahri.R

class Persegi : AppCompatActivity() {

    private lateinit var sisi : EditText
    private lateinit var luas : RadioButton
    private lateinit var keliling : RadioButton
    private lateinit var hitung : Button
    private lateinit var hasil : TextView

    private  var rumus : Int=0

    private lateinit var recyclerView : RecyclerView
    private lateinit var recyclerAdapter : RecyclerView.Adapter<*>
    private lateinit var viewManager : RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_persegi)

        val checkbox = findViewById<CheckBox>(R.id.checkBox)

        sisi = findViewById(R.id.Etsisi)
        luas = findViewById(R.id.rbluas)
        keliling = findViewById(R.id.rbkeliling)
        hitung = findViewById(R.id.btnhitung)
        hasil = findViewById(R.id.tvhasil)
        recyclerView = findViewById(R.id.listdata)

        val data = mutableListOf<DataPersegi>()
        viewManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerAdapter = AdapterPersegi(data)
        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = viewManager

        fun dadi(){
            var sisi = sisi.text.toString().toInt()

            if (luas.isChecked)
            {
                rumus= (sisi * sisi)
                hasil.setText(rumus.toString())
            }else
            {
                rumus = (sisi * 4)
                hasil.setText(rumus.toString())
            }
        }

        fun simpandata(){
            val sisi = sisi.text.toString()
            val hasil = hasil.text.toString()
            var rb = ""
            if (luas.isChecked){
                rb = "luas"
            } else {
                rb = "keliling"
            }
            val datapersegi = DataPersegi (sisi, rb , hasil)
            data.add(datapersegi)
            recyclerAdapter.notifyDataSetChanged()
        }

        hitung.setOnClickListener {
            if(checkbox.isChecked){
                dadi()
                simpandata()
            } else {
                dadi()
            }

        }

    }

    fun backToMenu(view: View){
        val pindah = Intent (this, Menu::class.java)
        startActivity(pindah)
    }

}