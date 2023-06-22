package com.example.cw2_227020684

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ThenextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thenext)

        val toolpage = findViewById<Button>(R.id.test1)

        toolpage.setOnClickListener{
            callActivity()
        }
    }

    private fun callActivity() {
        startActivity(Intent(this,ToolActivity::class.java))
    }
}