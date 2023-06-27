package com.example.cw2_227020684

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth

class ThenextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thenext)

        val toolpage = findViewById<Button>(R.id.test1)

        toolpage.setOnClickListener{
            callActivity()
        }

        val culturepage = findViewById<Button>(R.id.test2)

        culturepage.setOnClickListener{
            callActivity2()
        }

        val mainpage = findViewById<Button>(R.id.test3)

        mainpage.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            callActivity3()
        }

        val mappage = findViewById<Button>(R.id.test4)

        mappage.setOnClickListener{
            callActivity4()
        }
    }
    private fun callActivity() {
        startActivity(Intent(this,ToolActivity::class.java))
    }
    private fun callActivity2() {
        startActivity(Intent(this,CultureActivity::class.java))
    }

    private fun callActivity3() {
        startActivity(Intent(this,MainActivity::class.java))
    }

    private fun callActivity4() {
        startActivity(Intent(this,MpActivity::class.java))
    }


}