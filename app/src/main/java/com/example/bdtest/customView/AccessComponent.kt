package com.example.bdtest.customView

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import com.example.bdtest.R

class AccessComponent : View {

    val scale = resources.displayMetrics.density
    val colorUp = Color.BLUE
    var isRectangleTriangle: Boolean = false
    var BASE: Float = 100f
    var HEIGHT: Float = 100f


    constructor(ctx: Context): super(ctx)
    constructor(ctx: Context, attrs: AttributeSet): super(ctx, attrs){
        context.theme.obtainStyledAttributes(attrs,
        R.styleable.AccessComponent,0,0).apply {
            try {
                BASE = getFloat(R.styleable.AccessComponent_width_triangle, 100f)
                HEIGHT = getFloat(R.styleable.AccessComponent_height_triangle, 100f)
                isRectangleTriangle = getBoolean(R.styleable.AccessComponent_is_rectangle_triangle, false)
            } finally {
                recycle()
            }
        }
    }
    constructor(ctx: Context, attrs: AttributeSet, defStyleAttr: Int): super(ctx, attrs, defStyleAttr){
        
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val p1 = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = colorUp
            style = Paint.Style.FILL
        }
        val centerWidth = width / 2f
        val centerHeight = height / 2f
        val path = Path()
        path.moveTo(centerWidth, centerHeight)
        if(isRectangleTriangle){
            path.lineTo(centerWidth+((BASE/2) * scale), centerHeight - (HEIGHT / 2) * scale)
            path.lineTo(centerWidth+((BASE/2) * scale), centerHeight + (HEIGHT / 2) * scale)
            path.lineTo(centerWidth - ((BASE / 2) * scale), centerHeight + (HEIGHT / 2) * scale)

        }else{
            path.lineTo(centerWidth+((BASE/2) * scale), centerHeight + (HEIGHT / 2) * scale)
            path.lineTo(centerWidth - ((BASE / 2) * scale), centerHeight + (HEIGHT / 2) * scale)
            path.lineTo(centerWidth, centerHeight - ((HEIGHT / 2) * scale))
            path.lineTo(centerWidth+((BASE/2) * scale), centerHeight + (HEIGHT / 2) * scale)
        }
        canvas?.drawPath(path,p1)
    }
}