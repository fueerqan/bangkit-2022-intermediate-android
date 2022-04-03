package com.furqan.intermediateandroid

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.furqan.intermediateandroid.canvas.CanvasActivity
import com.furqan.intermediateandroid.custom_view.CustomViewActivity
import com.furqan.intermediateandroid.databinding.ActivityMainBinding
import com.furqan.intermediateandroid.property_animation.AnimationActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnGoToCustomView.setOnClickListener {
                startActivity(
                    Intent(
                        this@MainActivity,
                        CustomViewActivity::class.java
                    )
                )
            }

            btnGoToCanvas.setOnClickListener {
                startActivity(
                    Intent(
                        this@MainActivity,
                        CanvasActivity::class.java
                    )
                )
            }

            btnGoToAnimation.setOnClickListener {
                startActivity(
                    Intent(
                        this@MainActivity,
                        AnimationActivity::class.java
                    )
                )
            }
        }
    }
}