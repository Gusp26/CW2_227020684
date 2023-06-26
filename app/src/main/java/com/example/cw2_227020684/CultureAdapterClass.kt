package com.example.cw2_227020684

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CultureAdapterClass (private val cultureList: ArrayList<CultureDataClass>): RecyclerView.Adapter<CultureAdapterClass.ViewHolderClass>(){

    private  lateinit var mListener: OnItemClickListener

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(listener: OnItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CultureAdapterClass.ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolderClass(itemView,mListener)
    }

    override fun onBindViewHolder(holder: CultureAdapterClass.ViewHolderClass, position: Int) {
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

    class ViewHolderClass(itemView: View, listener: OnItemClickListener): RecyclerView.ViewHolder(itemView) {
        val rvImage:ImageView = itemView.findViewById(R.id.image)
        val rvTitle:TextView = itemView.findViewById(R.id.title)
        val rvDesc:TextView = itemView.findViewById(R.id.desc)
        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}