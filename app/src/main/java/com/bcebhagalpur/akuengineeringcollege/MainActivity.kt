package com.bcebhagalpur.akuengineeringcollege

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.DragEvent
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity: AppCompatActivity(), View.OnTouchListener, View.OnDragListener {
//    private val TAG = MainActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    btn.setOnClickListener { startActivity(Intent(this,MainActivity2::class.java)) }
        setListeners()

    }
    private fun setListeners() {
        tv_dropdrop.setOnTouchListener(this)
        ll_pinklayout.setOnDragListener(this)
    }
    override fun onDrag(view:View, dragEvent: DragEvent):Boolean {
        when (dragEvent.action) {
            DragEvent.ACTION_DRAG_ENDED -> {
//                tv_dropdrop.visibility=View.VISIBLE
//                tv_dropdrop1.visibility=View.VISIBLE
//                tv_dropdrop2.visibility=View.VISIBLE
                return true
            }
            DragEvent.ACTION_DRAG_EXITED -> {
                return true
            }
            DragEvent.ACTION_DRAG_ENTERED -> {
                return true
            }
            DragEvent.ACTION_DRAG_STARTED -> {
//                tv_dropdrop.visibility=View.GONE
//                tv_dropdrop1.visibility=View.GONE
//                tv_dropdrop2.visibility=View.GONE
                return true
            }
            DragEvent.ACTION_DROP -> {
                val tvState = dragEvent.localState as View
                val tvParent = tvState.parent as ViewGroup
                tvParent.removeView(tvState)
                val container = view as LinearLayout
                container.addView(tvState)
                tvParent.removeView(tvState)
                tvState.x = dragEvent.x
                tvState.y = dragEvent.y
                view.addView(tvState)
                view.setVisibility(View.VISIBLE)
                return true
            }
            DragEvent.ACTION_DRAG_LOCATION -> {
                return true
            }
            else -> return false
        }

    }
    override fun onTouch(view:View, motionEvent: MotionEvent):Boolean {
        return if (motionEvent.action === MotionEvent.ACTION_DOWN) {
            val dragShadowBuilder = View.DragShadowBuilder(view)
            view.startDrag(null, dragShadowBuilder, view, 0)
            true
        } else {
            false
        }
    }
}