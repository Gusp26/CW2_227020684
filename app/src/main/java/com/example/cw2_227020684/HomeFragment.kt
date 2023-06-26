package com.example.cw2_227020684

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.cw2_227020684.databinding.FragmentHomeBinding
import com.google.firebase.database.DatabaseReference
import java.io.ByteArrayOutputStream
import java.lang.Exception
import java.util.Base64

class HomeFragment : Fragment() {
    private lateinit var binding:FragmentHomeBinding
    private lateinit var db: DatabaseReference
    var nodeId = ""
    var sImage:String? =""

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
        val root:View = binding.root

        binding.btnAdd.setOnClickListener(){
            var myfileintent = Intent(Intent.ACTION_GET_CONTENT)
            myfileintent.setType("image/*")
            ActivityResultLauncher.launch(myfileintent)
        }

        binding.btnInsert.setOnClickListener(){

        }

        return root
    }

    private val ActivityResultLauncher = registerForActivityResult<Intent,ActivityResult>(
        ActivityResultContracts.StartActivityForResult()
    ){result:ActivityResult ->
        if (result.resultCode == AppCompatActivity.RESULT_OK){
            val uri = result.data!!.data
            try{
                val inputStream = context?.contentResolver?.openInputStream(uri!!)
                val myBitmap = BitmapFactory.decodeStream(inputStream)
                val stream = ByteArrayOutputStream()
                myBitmap.compress(Bitmap.CompressFormat.PNG,100,stream)
                val bytes = stream.toByteArray()
                sImage = Base64.getEncoder().encodeToString(bytes)
                binding.imageView.setImageBitmap(myBitmap)
                inputStream!!.close()
                Toast.makeText(context,"Image Selected", Toast.LENGTH_SHORT).show()
            }catch (ex: Exception){
                Toast.makeText(context,ex.message.toString(), Toast.LENGTH_SHORT).show()
            }
        }

    }

}