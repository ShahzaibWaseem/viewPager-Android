package com.shahzaib.viewpager.Tabs

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shahzaib.viewpager.databinding.Tab1Binding

class Tab1 : BaseFragment() {
    private var binding: Tab1Binding? = null
    private val TAG = "Tab1"
    private var animationChange = 0F

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        Log.e(TAG, "onCreateView")
        binding = Tab1Binding.inflate(layoutInflater)
        currentPosition = 0
        return binding!!.root
    }

    fun animate(positionOffset: Float, positionOffsetPixels: Int) {
        when {
            positionOffsetPixels <= 100 -> {
                binding!!.man.translationX = positionOffsetPixels.toFloat()
                binding!!.man.rotation = positionOffsetPixels.toFloat() * 0.03F
                binding!!.man.alpha = 1.0F - positionOffset * 2
    //            Log.i("OnPage", "<=50: translate: ${positionOffsetPixels.toFloat() * 0.3F}, rotate: ${positionOffsetPixels.toFloat() * 0.03F}")
                animationChange = positionOffsetPixels.toFloat() * 2
            }
            positionOffsetPixels in 101..200 -> {
                binding!!.man.translationX = animationChange - positionOffsetPixels.toFloat()
                binding!!.man.rotation = positionOffsetPixels.toFloat() * 0.03F
                binding!!.man.alpha = 1.0F - positionOffset * 2
    //            Log.i("OnPage", "51..100: translate: ${animationChange - positionOffsetPixels.toFloat()}, rotate: ${positionOffsetPixels.toFloat() * 0.03F}")
            }
            else -> {
                binding!!.man.translationX = animationChange - positionOffsetPixels.toFloat()
                binding!!.man.rotation = positionOffsetPixels.toFloat() * 0.03F
                binding!!.man.alpha = 1.0F - positionOffset * 2
    //            Log.i("OnPage", "51..100: translate: ${animationChange - positionOffsetPixels.toFloat()}")
            }
        }

        binding!!.background.translationX = - positionOffsetPixels.toFloat()
        binding!!.background.rotation = - positionOffsetPixels.toFloat() * 0.07F
        binding!!.background.alpha = 1.0F - positionOffset * 2

        binding!!.planner.translationX = - positionOffsetPixels.toFloat() * 0.2F
        binding!!.planner.alpha = 1.0F - positionOffset * 2
    }
}