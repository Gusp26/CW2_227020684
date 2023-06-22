package com.example.cw2_227020684

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ToolDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tool_detail)

        val getData = intent.getParcelableExtra<ToolDataClass>("Tool")
        if (getData != null) {
            val detailTitle: TextView = findViewById(R.id.detailTitle)
            val detailImage: ImageView = findViewById(R.id.detailImage)
            detailTitle.text = getData.toolTitle
            detailImage.setImageResource(getData.toolDetailImage)
        }
    }
}