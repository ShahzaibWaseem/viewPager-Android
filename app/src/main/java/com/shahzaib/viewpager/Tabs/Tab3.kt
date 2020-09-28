package com.shahzaib.viewpager.Tabs

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shahzaib.viewpager.databinding.Tab3Binding

class Tab3: BaseFragment() {
    private lateinit var binding: Tab3Binding
    private val TAG = "Tab3"
    private var animationChange = 0F

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        Log.e(TAG, "onCreateView")
        binding = Tab3Binding.inflate(layoutInflater)
        currentPosition = 2
        return binding.root
    }

    fun animateImages(positionOffset: Float, positionOffsetPixels: Int) {
        when {
            positionOffsetPixels <= 150 -> {
                binding.background.translationX = - positionOffsetPixels.toFloat() * 0.7F
                binding.background.translationY = positionOffsetPixels.toFloat() * 0.7F
                binding.background.rotation = - positionOffsetPixels.toFloat() * 0.07F
                binding.background.alpha = 1.0F - positionOffset * 2

                binding.pills.translationX = - positionOffsetPixels.toFloat() * 0.7F
                binding.pills.translationY = positionOffsetPixels.toFloat() * 0.7F
                binding.pills.rotation = - positionOffsetPixels.toFloat() * 0.07F
                binding.pills.alpha = 1.0F - positionOffset * 2

                animationChange = - positionOffsetPixels.toFloat() * 2 * 0.7F
            }
            positionOffsetPixels in 151..300 -> {
                binding.background.translationX = animationChange + positionOffsetPixels.toFloat() * 0.7F
                binding.background.rotation = - positionOffsetPixels.toFloat() * 0.07F
                binding.background.alpha = 1.0F - positionOffset * 2

                binding.pills.translationX = animationChange + positionOffsetPixels.toFloat() * 0.7F
                binding.pills.rotation = - positionOffsetPixels.toFloat() * 0.07F
                binding.pills.alpha = 1.0F - positionOffset * 2
            }

            else -> {
                binding.background.translationX = animationChange + positionOffsetPixels.toFloat() * 0.7F
                binding.background.rotation = - positionOffsetPixels.toFloat() * 0.07F
                binding.background.alpha = 1.0F - positionOffset * 2

                binding.pills.translationX = animationChange + positionOffsetPixels.toFloat() * 0.7F
                binding.pills.rotation = - positionOffsetPixels.toFloat() * 0.07F
                binding.pills.alpha = 1.0F - positionOffset * 2
            }
        }

        binding.alarmClock.translationX = positionOffsetPixels.toFloat() * 0.6F
        binding.alarmClock.alpha = 1.0F - positionOffset * 2

        binding.man.translationX = - positionOffsetPixels.toFloat() * 0.2F
        binding.man.alpha = 1.0F - positionOffset * 2
    }

    fun animateText(positionOffset: Float, positionOffsetPixels: Int) {
        binding.textTitle.translationX = positionOffsetPixels.toFloat() * 0.4F
        binding.textTitle.rotationY = positionOffsetPixels.toFloat() * 0.08F
        binding.textTitle.alpha = 1.0F - positionOffset * 3

        binding.textBody.translationX = positionOffsetPixels.toFloat() * 0.4F
        binding.textBody.rotationY = positionOffsetPixels.toFloat() * 0.08F
        binding.textBody.alpha = 1.0F - positionOffset * 3
    }
}