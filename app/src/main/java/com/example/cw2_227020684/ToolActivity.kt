package com.example.cw2_227020684

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class ToolActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<ToolDataClass>
    private lateinit var imageList:Array<Int>
    private lateinit var titleList:Array<String>
    private lateinit var detailImageList: Array<Int>
    private lateinit var myAdapter: ToolAdapterClass
    private lateinit var searchView: SearchView
    private lateinit var searchList: ArrayList<ToolDataClass>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tool)

        imageList = arrayOf(
            R.drawable.bigscissor,
            R.drawable.smallscissor,
            R.drawable.brush,
            R.drawable.oilbrush,
            R.drawable.clamp,
            R.drawable.hatchet,
            R.drawable.sawblade,
            R.drawable.stapler,
            R.drawable.bamboostick,
            R.drawable.glue,
            R.drawable.fountainpen,
            R.drawable.ironwire,
            R.drawable.paper,
            R.drawable.fluorescentoil,
            R.drawable.magneticoil,
            R.drawable.bamboo)
        titleList = arrayOf(
            "Scissor",
            "Scissor",
            "Brush",
            "Oil Brush",
            "Clamp",
            "Hatchet",
            "Saw Blade,",
            "Stapler",
            "Bamboo Stick",
            "Glue",
            "Fountain Pen",
            "Ironwire",
            "Paper",
            "Fluorescent Oil",
            "M agnetic Oil",
            "Bamboo")
        detailImageList = arrayOf(
            R.drawable.bigscissor,
            R.drawable.smallscissor,
            R.drawable.brush,
            R.drawable.oilbrush,
            R.drawable.clamp,
            R.drawable.hatchet,
            R.drawable.sawblade,
            R.drawable.stapler,
            R.drawable.bamboostick,
            R.drawable.glue,
            R.drawable.fountainpen,
            R.drawable.ironwire,
            R.drawable.paper,
            R.drawable.fluorescentoil,
            R.drawable.magneticoil,
            R.drawable.bamboo)

        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.search)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        dataList = arrayListOf<ToolDataClass>()
        searchList = arrayListOf<ToolDataClass>()
        getData()
        searchView.clearFocus()
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchView.clearFocus()
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                searchList.clear()
                val searchText = newText!!.toLowerCase(Locale.getDefault())
                if (searchText.isNotEmpty()){
                    dataList.forEach{
                        if (it.toolTitle.toLowerCase(Locale.getDefault()).contains(searchText)) {
                            searchList.add(it)
                        }
                    }
                    recyclerView.adapter!!.notifyDataSetChanged()
                } else {
                    searchList.clear()
                    searchList.addAll(dataList)
                    recyclerView.adapter!!.notifyDataSetChanged()
                }
                return false
            }
        })
        myAdapter = ToolAdapterClass(searchList)
        recyclerView.adapter = myAdapter
        myAdapter.onItemClick = {
            val intent = Intent(this, ToolDetailActivity::class.java)
            intent.putExtra("Tool", it)
            startActivity(intent)
        }
    }
    private fun getData(){
        for (i in imageList.indices){
            val dataClass = ToolDataClass(imageList[i], titleList[i], detailImageList[i])
            dataList.add(dataClass)
        }
        searchList.addAll(dataList)
        recyclerView.adapter = ToolAdapterClass(searchList)

    }
}