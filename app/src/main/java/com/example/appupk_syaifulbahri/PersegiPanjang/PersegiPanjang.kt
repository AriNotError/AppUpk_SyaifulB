package com.example.appupk_syaifulbahri.PersegiPanjang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appupk_syaifulbahri.Menu
import com.example.appupk_syaifulbahri.R

class PersegiPanjang : AppCompatActivity() {

    private lateinit var panjang : EditText
    private lateinit var lebar : EditText
    private lateinit var luas: RadioButton
    private lateinit var keliling : RadioButton
    private lateinit var hasil : TextView
    private lateinit var button : Button
    private lateinit var RecyclerView : RecyclerView
    private lateinit var RecyclerAdapter : RecyclerView.Adapter<*>
    private lateinit var ViewManager : RecyclerView.LayoutManager

    private var rumus : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_persegi_panjang)

        val checkbox = findViewById<CheckBox>(R.id.checkBox2)

        panjang = findViewById(R.id.panjang)
        lebar = findViewById(R.id.lebar)
        luas = findViewById(R.id.rbluas)
        keliling = findViewById(R.id.rbkeliling)
        hasil = findViewById(R.id.txthasil)
        button = findViewById(R.id.btnHitung)
        RecyclerView = findViewById(R.id.listData)

        val data = mutableListOf<DataPersegiPanjang>()
        ViewManager = LinearLayoutManager (this , LinearLayoutManager.HORIZONTAL, false)
        RecyclerAdapter = AdapterPersegiPanjang(data)
        RecyclerView.adapter = RecyclerAdapter
        RecyclerView.layoutManager = ViewManager

        fun dadi(){
            var panjang = panjang.text.toString().toInt()
            var lebar = lebar.text.toString().toInt()

            if (luas.isChecked)
            {
                rumus = (panjang * lebar)
                hasil.setText(rumus.toString())
            } else
            {
                rumus = ((2* lebar) + (2 * panjang))
                hasil.setText(rumus.toString())

            }
        }

        fun simpan(){
            val panjang = panjang.text.toString()
            val lebar = lebar.text.toString()
            val hasil = hasil.text.toString()
            var rb = ""
            if(keliling.isChecked){
                rb = "Keliling"
            } else {
                rb = "Luas"
            }

            val dataa = DataPersegiPanjang(panjang,lebar, rb, hasil)
            data.add(dataa)
            RecyclerAdapter.notifyDataSetChanged()
        }


        button.setOnClickListener {
            if (checkbox.isChecked){
                dadi()
                simpan()
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