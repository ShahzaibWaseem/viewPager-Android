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

    fun animateImages(positionOffset: Float, positionOffsetPixels: Int) {
        when {
            positionOffsetPixels <= 100 -> {
                binding!!.man.translationX = positionOffsetPixels.toFloat()
                binding!!.man.rotation = positionOffsetPixels.toFloat() * 0.03F
                binding!!.man.alpha = 1.0F - positionOffset * 2
                animationChange = positionOffsetPixels.toFloat() * 2
            }
            positionOffsetPixels in 101..200 -> {
                binding!!.man.translationX = animationChange - positionOffsetPixels.toFloat()
                binding!!.man.rotation = positionOffsetPixels.toFloat() * 0.03F
                binding!!.man.alpha = 1.0F - positionOffset * 2
            }
            else -> {
                binding!!.man.translationX = animationChange - positionOffsetPixels.toFloat()
                binding!!.man.rotation = positionOffsetPixels.toFloat() * 0.03F
                binding!!.man.alpha = 1.0F - positionOffset * 2
            }
        }

        binding!!.background.translationX = - positionOffsetPixels.toFloat()
        binding!!.background.rotation = - positionOffsetPixels.toFloat() * 0.07F
        binding!!.background.alpha = 1.0F - positionOffset * 2

        binding!!.planner.translationX = - positionOffsetPixels.toFloat() * 0.2F
        binding!!.planner.alpha = 1.0F - positionOffset * 2
    }

    fun animateText(positionOffset: Float, positionOffsetPixels: Int) {
        binding!!.textTitle.translationX = positionOffsetPixels.toFloat() * 0.4F
        binding!!.textTitle.rotationY = positionOffsetPixels.toFloat() * 0.08F
        binding!!.textTitle.alpha = 1.0F - positionOffset * 3

        binding!!.textBody.translationX = positionOffsetPixels.toFloat() * 0.4F
        binding!!.textBody.rotationY = positionOffsetPixels.toFloat() * 0.08F
        binding!!.textBody.alpha = 1.0F - positionOffset * 3
    }
}