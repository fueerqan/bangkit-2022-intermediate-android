package com.furqan.intermediateandroid.property_animation

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.furqan.intermediateandroid.databinding.ActivityAnimationBinding
import kotlin.random.Random

class AnimationActivity : AppCompatActivity() {

    companion object {
        private const val MIN_TRANSLATION = 100f
        private const val MAX_TRANSLATION = 500f

        private val TRANSLATION_OPTION = listOf(
            "translationX",
            "translationY"
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAnimationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            root.setOnClickListener {
                val translation = Random.nextInt(0, TRANSLATION_OPTION.size)
                ObjectAnimator.ofFloat(
                    tvCatchMe,
                    TRANSLATION_OPTION[translation],
                    randomPosition()
                ).apply {
                    duration = 500
                    start()
                }
            }
        }
    }

    private fun randomPosition(): Float =
        MIN_TRANSLATION + Random.nextFloat() * (MAX_TRANSLATION - MIN_TRANSLATION)
}