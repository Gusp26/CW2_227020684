package com.example.cw2_227020684

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cw2_227020684.databinding.ActivityCultureBinding

class CultureActivity : AppCompatActivity() {
    private lateinit var binding:ActivityCultureBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_culture)
        binding = ActivityCultureBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragment = HomeFragment()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment).commit()

    }

}