package com.example.cw2_227020684


import android.content.ContentValues
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.ByteArrayOutputStream
import java.io.File
import java.util.UUID

class CameraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

    }

    companion object {
        val REQUEST_IMAGE_CATPURE = 1
        val REQUEST_SELECT_IMAGE = 2
    }
    fun onCameraClicked(v : View){
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CATPURE)
    }

    fun onSaveClicked(v : View){
        val imageView = findViewById<ImageView>(R.id.imageView)
        saveImage(imageView,this)
    }

    private fun saveImage(itemImage: View, activity: CameraActivity) {
        val fileName: String
        val imageFromView = getBitmapFromView(itemImage)

        ByteArrayOutputStream().apply {
            imageFromView.compress(Bitmap.CompressFormat.JPEG, 100, this)
            fileName = UUID.nameUUIDFromBytes(this.toByteArray()).toString().replace("-", "")
        }

        val imageFile =  File("${activity.getExternalFilesDir(Environment.DIRECTORY_PICTURES)}/ChatOut/$fileName.jpg/")

        if (!imageFile.exists()) {

            val contentResolver = ContentValues().apply {
                put(MediaStore.Images.Media.DATE_ADDED, System.currentTimeMillis())
                put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
                put(MediaStore.Images.Media.DATA, imageFile.absolutePath)
            }

            activity.contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentResolver).apply {
                imageFromView.compress(Bitmap.CompressFormat.JPEG, 100, activity.contentResolver.openOutputStream(this!!))
            }

            Toast.makeText(activity, "saved", Toast.LENGTH_SHORT).show()
        } else
            Toast.makeText(activity, "Already saved", Toast.LENGTH_SHORT).show()
    }



    fun getBitmapFromView(view: View): Bitmap {
        return Bitmap.createBitmap(view.width, view.height,Bitmap.Config.ARGB_8888).apply {
            Canvas(this).apply {
                view.draw(this)
            }
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val imageView = findViewById<ImageView>(R.id.imageView)
        if(requestCode == REQUEST_SELECT_IMAGE && resultCode == RESULT_OK) {
            val selectedImageUri = data?.data as Uri
            imageView.setImageURI(selectedImageUri)
        } else if (requestCode == REQUEST_IMAGE_CATPURE && resultCode == RESULT_OK) {
            val bitmap = data?.extras?.get("data") as Bitmap
            imageView.setImageBitmap(bitmap)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}