package com.shahzaib.viewpager.Tabs

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shahzaib.viewpager.databinding.Tab5Binding

class Tab5: BaseFragment() {
    private lateinit var binding: Tab5Binding
    private val TAG = "Tab5"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = Tab5Binding.inflate(layoutInflater)
        Log.e(TAG, "onCreateView")
        return binding.root
    }

    fun animateImages(positionOffset: Float, positionOffsetPixels: Int) {
        binding.background.translationX = positionOffsetPixels.toFloat() * 0.6F
        binding.background.translationY = positionOffsetPixels.toFloat() * 0.6F
        binding.background.alpha = 1.0F - positionOffset * 2

        binding.computer.translationX = positionOffsetPixels.toFloat() * 0.6F
        binding.computer.translationY = positionOffsetPixels.toFloat() * 0.6F
        binding.computer.alpha = 1.0F - positionOffset * 2

        binding.man.translationX = - positionOffsetPixels.toFloat() * 0.4F
        binding.man.translationY = - positionOffsetPixels.toFloat() * 0.2F
        binding.man.alpha = 1.0F - positionOffset * 2
    }

    fun animateText(positionOffset: Float, positionOffsetPixels: Int) {
        binding.text.translationX = positionOffsetPixels.toFloat() * 0.4F
        binding.text.rotationY = positionOffsetPixels.toFloat() * 0.08F
        binding.text.alpha = 1.0F - positionOffset * 3
    }
}