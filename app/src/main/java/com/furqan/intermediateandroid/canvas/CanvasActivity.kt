package com.furqan.intermediateandroid.canvas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.furqan.intermediateandroid.R
import com.furqan.intermediateandroid.databinding.ActivityCanvasBinding

class CanvasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCanvasBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}