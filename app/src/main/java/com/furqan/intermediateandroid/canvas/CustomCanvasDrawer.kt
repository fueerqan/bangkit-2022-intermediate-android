package com.furqan.intermediateandroid.canvas

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatImageView

@SuppressLint("ClickableViewAccessibility")
class CustomCanvasDrawer @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    private lateinit var currentPath: Path
    private var currentColor: String = "#FF0000"
    private var currentStrokeWidth = 5F

    private var strokePaint: Paint = Paint().apply {
        isAntiAlias = true
        style = Paint.Style.STROKE
        color = Color.parseColor(currentColor)
        strokeJoin = Paint.Join.ROUND
        strokeCap = Paint.Cap.ROUND
        strokeWidth = currentStrokeWidth
    }

    private val paths: ArrayList<Path> = arrayListOf()

    init {
        setOnTouchListener { _, motionEvent ->
            val xPosition = motionEvent.x
            val yPosition = motionEvent.y

            when (motionEvent.action) {
                MotionEvent.ACTION_DOWN -> {
                    currentPath = Path()
                    currentPath.moveTo(xPosition, yPosition)
                    paths.add(currentPath)
                }
                MotionEvent.ACTION_MOVE -> {
                    currentPath.lineTo(xPosition, yPosition)
                    invalidate()
                }
                MotionEvent.ACTION_UP -> {
                    currentPath.lineTo(xPosition, yPosition)
                    invalidate()
                }
                else -> {}
            }

            true
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.save()

        paths.forEach {
            canvas?.drawPath(it, strokePaint)
        }

        canvas?.restore()
    }
}