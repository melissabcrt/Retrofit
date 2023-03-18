package com.example.retrofit.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.R
import com.squareup.picasso.Picasso

class PerroAdapter (
    private val perros: List<String>,
    private val context: Context):
    RecyclerView.Adapter<PerroAdapter.PerroViewHolder>() {
        inner class PerroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val imgDog: ImageView = itemView.findViewById(R.id.ivdoggie)
            val textDog: TextView = itemView.findViewById(R.id.tvroute)
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PerroViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.perros, parent, false)
            return PerroViewHolder(itemView)
        }
        override fun onBindViewHolder(holder: PerroViewHolder, position: Int) {
            val imgUrl = perros[position]
            holder.textDog.text=imgUrl
            // Aquí se carga la imagen en el ImageView usando Picasso
            Picasso.get()
                .load(imgUrl)
                .placeholder(R.drawable.placeholder) // Puedes usar una imagen de placeholder mientras se carga la imagen real
                .error(R.drawable.placeholder) // Puedes usar una imagen de error en caso de que no se pueda cargar la imagen real
                .into(holder.imgDog)
        }
        override fun getItemCount(): Int {
            return perros.size
        }
}