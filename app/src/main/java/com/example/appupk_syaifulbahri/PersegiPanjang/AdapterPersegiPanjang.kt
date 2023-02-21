package com.example.appupk_syaifulbahri.PersegiPanjang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appupk_syaifulbahri.R
import java.nio.file.Files.size

class AdapterPersegiPanjang (private val dataset : MutableList<DataPersegiPanjang>):
        RecyclerView.Adapter<AdapterPersegiPanjang.DataHolder>(){
            class DataHolder(view: View): RecyclerView.ViewHolder(view){
                var panjang = view.findViewById<TextView>(R.id.panjang)
                var lebar = view.findViewById<TextView>(R.id.lebar)
                var keliling = view.findViewById<TextView>(R.id.keliling)
                var hasil = view.findViewById<TextView>(R.id.hasil)
                var hapus = view.findViewById<ImageView>(R.id.hapus)
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
        var view = LayoutInflater.from(parent.context).inflate(
            R.layout.activity_adapter_persegipanjang, parent, false
        )
        return DataHolder(view)
    }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {
        holder.panjang.text = dataset[position].panjang
        holder.lebar.text = dataset[position].lebar
        holder.keliling.text = dataset[position].keliling
        holder.hasil.text = dataset[position].hasil

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