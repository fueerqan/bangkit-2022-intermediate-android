package com.furqan.intermediateandroid.custom_view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.content.withStyledAttributes
import com.furqan.intermediateandroid.R
import com.furqan.intermediateandroid.databinding.ViewCustomCounterBinding

class CustomCounterView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val binding = ViewCustomCounterBinding.inflate(
        LayoutInflater.from(context),
        this,
        true
    )

    private var minimumValue = Int.MIN_VALUE
    private var maximumValue = Int.MAX_VALUE
    private var startValue = 0

    init {
        context.withStyledAttributes(attrs, R.styleable.CustomCounterView) {
            minimumValue = getInteger(R.styleable.CustomCounterView_minimumValue, Int.MIN_VALUE)
            maximumValue = getInteger(R.styleable.CustomCounterView_maximumValue, Int.MAX_VALUE)
            startValue = getInteger(R.styleable.CustomCounterView_startValue, 0)
        }

        with(binding) {
            btnSubstractCustom.setOnClickListener {
                if (getCurrentCounter() > minimumValue) {
                    val counter = getCurrentCounter() - 1
                    edtCounterCustom.setText(counter.toString())
                } else {
                    Toast.makeText(context, "Already Minimum", Toast.LENGTH_SHORT).show()
                }
            }

            btnPlusCustom.setOnClickListener {
                if (getCurrentCounter() < maximumValue) {
                    val counter = getCurrentCounter() + 1
                    edtCounterCustom.setText(counter.toString())
                } else {
                    Toast.makeText(context, "Already Maximum", Toast.LENGTH_SHORT).show()
                }
            }

            edtCounterCustom.setText(startValue.toString())
        }
    }

    fun getCurrentCounter(): Int =
        binding.edtCounterCustom.text.toString().toInt()

    fun setMinMaxValue(minValue: Int = Int.MIN_VALUE, maxValue: Int = Int.MAX_VALUE) {
        minimumValue = minValue
        maximumValue = maxValue
    }

    fun setStartValue(startValue: Int) {
        this.startValue = startValue
        binding.edtCounterCustom.setText(startValue.toString())
    }

}