package com.furqan.intermediateandroid.custom_view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.furqan.intermediateandroid.databinding.ActivityCustomViewBinding

class CustomViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCustomViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            // manual setup
            btnSubstract.setOnClickListener {
                val counter = edtCounter.text.toString().toInt() - 1
                edtCounter.setText(counter.toString())
            }

            btnPlus.setOnClickListener {
                val counter = edtCounter.text.toString().toInt() + 1
                edtCounter.setText(counter.toString())
            }

            myCustomCounter.setMinMaxValue(maxValue = 10)
            myCustomCounter.setStartValue(3)

            myCustomCounter1.setMinMaxValue(minValue = 0)

            myCustomCounter2.setMinMaxValue(4, 7)
            myCustomCounter2.setStartValue(5)
        }
    }
}