package com.furqan.intermediateandroid.media

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.furqan.intermediateandroid.R
import com.furqan.intermediateandroid.databinding.ActivityMediaBinding

class MediaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMediaBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}