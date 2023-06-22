package com.example.cw2_227020684

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ToolAdapterClass(private val toolList: ArrayList<ToolDataClass>): RecyclerView.Adapter<ToolAdapterClass.ViewHolderClass>() {
    var onItemClick: ((ToolDataClass) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolderClass(itemView)
    }
    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = toolList[position]
        holder.rvImage.setImageResource(currentItem.toolImage)
        holder.rvTitle.text = currentItem.toolTitle
        holder.itemView.setOnClickListener{
            onItemClick?.invoke(currentItem)
        }
    }
    override fun getItemCount(): Int {
        return toolList.size
    }
    class ViewHolderClass(itemView: View): RecyclerView.ViewHolder(itemView) {
        val rvImage:ImageView = itemView.findViewById(R.id.image)
        val rvTitle:TextView = itemView.findViewById(R.id.title)
    }
}