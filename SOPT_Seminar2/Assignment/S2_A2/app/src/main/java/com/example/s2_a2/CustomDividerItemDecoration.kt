package com.example.s2_a2

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class CustomDividerItemDecoration(context: Context) : RecyclerView.ItemDecoration() {
    private val drawableline: Drawable?
    init {
        drawableline = ContextCompat.getDrawable(context, R.drawable.recyclerline)
    }
    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight
        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)
            val params = child.layoutParams as RecyclerView.LayoutParams
            val top = child.bottom + params.bottomMargin
            val bottom = top + drawableline!!.intrinsicHeight
            drawableline.setBounds(left, top, right, bottom)
            drawableline.draw(c)
        }
    }
}