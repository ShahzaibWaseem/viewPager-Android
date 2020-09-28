package com.shahzaib.viewpager.Tabs

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shahzaib.viewpager.databinding.Tab6Binding

class Tab6: BaseFragment() {
    private lateinit var binding: Tab6Binding
    private val TAG = "Tab6"
    private var animationChange = 0F

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        Log.e(TAG, "onCreateView")
        binding = Tab6Binding.inflate(layoutInflater)
        currentPosition = 5
        return binding.root
    }

    fun animateImages(positionOffset: Float, positionOffsetPixels: Int) {
        binding.background.translationX = positionOffsetPixels.toFloat() * 0.6F
        binding.background.alpha = 1.0F - positionOffset * 2

        binding.computer.translationX = positionOffsetPixels.toFloat() * 0.2F
        binding.computer.alpha = 1.0F - positionOffset * 2

        binding.man.translationX =  positionOffsetPixels.toFloat() * 0.2F
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