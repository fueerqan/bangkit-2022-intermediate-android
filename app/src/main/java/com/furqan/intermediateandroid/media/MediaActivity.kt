package com.furqan.intermediateandroid.media

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.furqan.intermediateandroid.databinding.ActivityMediaBinding

class MediaActivity : AppCompatActivity() {

    private val activityResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val image = it.data?.extras?.get("data") as Bitmap?
                image?.let { bitmap ->
                    binding.ivThumbnail.setImageBitmap(bitmap)
                }
            }
        }

    private lateinit var binding: ActivityMediaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMediaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            binding.btnCamera.setOnClickListener {
                try {
                    activityResult.launch(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
                } catch (t: Throwable) {
                    Toast.makeText(this@MediaActivity, t.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}