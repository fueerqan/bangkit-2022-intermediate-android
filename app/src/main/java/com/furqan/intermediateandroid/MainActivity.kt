package com.furqan.intermediateandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.furqan.intermediateandroid.canvas.CanvasActivity
import com.furqan.intermediateandroid.custom_view.CustomViewActivity
import com.furqan.intermediateandroid.databinding.ActivityMainBinding
import com.furqan.intermediateandroid.media.MediaActivity
import com.furqan.intermediateandroid.motion_layout.MotionLayoutActivity
import com.furqan.intermediateandroid.property_animation.AnimationActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val locale = Locale.getDefault()
        Toast.makeText(this, locale.language, Toast.LENGTH_SHORT).show()


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

            btnGoToMotion.setOnClickListener {
                startActivity(
                    Intent(
                        this@MainActivity,
                        MotionLayoutActivity::class.java
                    )
                )
            }

            btnGoToMedia.setOnClickListener {
                startActivity(
                    Intent(
                        this@MainActivity,
                        MediaActivity::class.java
                    )
                )
            }
        }
    }
}