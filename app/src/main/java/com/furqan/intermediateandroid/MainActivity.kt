package com.furqan.intermediateandroid

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.furqan.intermediateandroid.custom_view.CustomViewActivity
import com.furqan.intermediateandroid.databinding.ActivityMainBinding

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
        }
    }
}