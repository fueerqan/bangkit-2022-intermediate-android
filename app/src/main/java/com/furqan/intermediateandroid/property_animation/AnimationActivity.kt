package com.furqan.intermediateandroid.property_animation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.furqan.intermediateandroid.databinding.ActivityAnimationBinding

class AnimationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAnimationBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}