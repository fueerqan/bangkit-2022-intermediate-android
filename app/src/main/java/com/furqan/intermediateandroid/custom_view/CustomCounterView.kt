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

    private var binding: ViewCustomCounterBinding = ViewCustomCounterBinding.inflate(
        LayoutInflater.from(context),
        this,
        true
    )

    var listener: ActionListener? = null
    private var minimumValue = Int.MIN_VALUE
    private var maximumValue = Int.MAX_VALUE
    private var startValue = 0

    init {
        context.withStyledAttributes(attrs, R.styleable.CustomCounterView) {
            minimumValue = getInteger(R.styleable.CustomCounterView_minValue, Int.MIN_VALUE)
            maximumValue = getInteger(R.styleable.CustomCounterView_maxValue, Int.MAX_VALUE)
            startValue = getInteger(R.styleable.CustomCounterView_startValue, 0)
        }

        with(binding) {
            edtCounterCustom.setText(startValue.toString())

            btnSubstractCustom.setOnClickListener {
                if (getCurrentCounter() > minimumValue) {
                    val counter = getCurrentCounter() - 1
                    edtCounterCustom.setText(counter.toString())
                } else {
                    Toast.makeText(
                        context,
                        "Cannot Substract Anymore, Meet the Minimum Value!",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                listener?.onSubsctractClicked()
            }

            btnPlusCustom.setOnClickListener {
                if (getCurrentCounter() < maximumValue) {
                    val counter = getCurrentCounter() + 1
                    edtCounterCustom.setText(counter.toString())
                } else {
                    Toast.makeText(
                        context,
                        "Cannot Add Anymore, Meet the Maximum Value!",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                listener?.onPlusClicked()
            }
        }
    }

    fun setMinMax(minValue: Int = Int.MIN_VALUE, maxValue: Int = Int.MAX_VALUE) {
        minimumValue = minValue
        maximumValue = maxValue
    }

    fun setStartValue(startValue: Int) {
        this.startValue = startValue
    }

    fun getCurrentCounter(): Int =
        binding.edtCounterCustom.text.toString().toInt()

    interface ActionListener {
        fun onSubsctractClicked()
        fun onPlusClicked()
    }

}