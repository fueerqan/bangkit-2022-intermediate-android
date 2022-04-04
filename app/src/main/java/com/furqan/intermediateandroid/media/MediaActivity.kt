package com.furqan.intermediateandroid.media

import android.content.Intent
import android.content.Intent.ACTION_GET_CONTENT
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.furqan.intermediateandroid.databinding.ActivityMediaBinding

class MediaActivity : AppCompatActivity() {

    private val cameraResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val image = it.data?.extras?.get("data") as Bitmap?
                image?.let { bitmap ->
                    binding.ivThumbnail.setImageBitmap(bitmap)
                }
            }
        }

    private val galleryResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val uri = it.data?.data
                uri?.let { mUri ->
                    binding.ivThumbnail.setImageURI(mUri)
                }
            }
        }

    private lateinit var binding: ActivityMediaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMediaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnCamera.setOnClickListener {
                try {
                    cameraResult.launch(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
                } catch (t: Throwable) {
                    Toast.makeText(this@MediaActivity, t.message, Toast.LENGTH_LONG).show()
                }
            }

            btnGallery.setOnClickListener {
                val intent = Intent()
                intent.action = ACTION_GET_CONTENT
                intent.type = "image/*"
                val chooser = Intent.createChooser(
                    intent,
                    "Choose a Picture"
                )
                galleryResult.launch(chooser)
            }
        }
    }
}