package com.example.cw2_227020684

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cw2_227020684.databinding.FragmentHomeBinding
import com.example.cw2_227020684.databinding.FragmentListBinding
import com.google.firebase.database.DatabaseReference

class HomeFragment : Fragment() {
    private lateinit var binding:FragmentHomeBinding
    private lateinit var db: DatabaseReference
    var nodeId = ""
    var sImage:String? =""
    var desc:String? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

}