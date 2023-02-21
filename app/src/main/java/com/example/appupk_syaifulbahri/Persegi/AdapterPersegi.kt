package com.example.appupk_syaifulbahri.Persegi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appupk_syaifulbahri.R

class AdapterPersegi (private val dataset : MutableList<DataPersegi>):
        RecyclerView.Adapter<AdapterPersegi.DataHolder>(){
            class DataHolder (view : View): RecyclerView.ViewHolder(view){

                var sisi = view.findViewById<TextView>(R.id.sisi)
                var luas = view.findViewById<TextView>(R.id.luas)
                var hasil = view.findViewById<TextView>(R.id.hasil)
                var hapus = view.findViewById<ImageView>(R.id.hapus)

            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
        val view = LayoutInflater.from(parent.context).inflate(
           R.layout.activity_adapter_persegi, parent , false
        )
           return DataHolder(view)
    }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {
        holder.sisi.text =dataset[position].sisi
        holder.luas.text =dataset[position].luas
        holder.hasil.text =dataset[position].hasil

        holder.hapus.setOnClickListener {
            dataset.removeAt(position)
            notifyItemRangeRemoved(position, dataset.size)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}