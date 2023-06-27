package com.example.cw2_227020684

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CultureAdapterClass (private val cultureList: ArrayList<CultureDataClass>): RecyclerView.Adapter<CultureAdapterClass.ViewHolderClass>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolderClass(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = cultureList[position]
        holder.rvTitle.text = currentItem.name.toString()
        holder.rvDesc.text = currentItem.desc.toString()
        val bytes = android.util.Base64.decode(currentItem.sImage,
             android.util.Base64.DEFAULT)
        val bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.size)
        holder.rvImage.setImageBitmap(bitmap)
    }

    override fun getItemCount(): Int {
        return cultureList.size
    }

    class ViewHolderClass(itemView: View): RecyclerView.ViewHolder(itemView) {
        val rvTitle:TextView = itemView.findViewById(R.id.title)
        val rvDesc:TextView = itemView.findViewById(R.id.desc)
        val rvImage:ImageView = itemView.findViewById(R.id.image)
    }
}