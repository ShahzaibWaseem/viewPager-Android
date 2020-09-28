package com.shahzaib.viewpager.Tabs

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shahzaib.viewpager.databinding.Tab2Binding

class Tab2: BaseFragment() {
    private lateinit var binding: Tab2Binding
    private val TAG = "Tab2"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        Log.e(TAG, "onCreateView")
        binding = Tab2Binding.inflate(layoutInflater)
        currentPosition = 1
        return binding.root
    }

    fun animateImages(positionOffset: Float, positionOffsetPixels: Int) {
        binding.doctor.translationX = - positionOffsetPixels.toFloat() * 0.2F
        binding.doctor.rotation = - positionOffsetPixels.toFloat() * 0.03F
        binding.doctor.alpha = 1.0F - positionOffset * 2

        binding.background.translationX = - positionOffsetPixels.toFloat() * 0.5F
        binding.background.alpha = 1.0F - positionOffset * 2

        binding.computer.translationX = - positionOffsetPixels.toFloat() * 0.2F
        binding.computer.rotation = - positionOffsetPixels.toFloat() * 0.03F
        binding.computer.alpha = 1.0F - positionOffset * 2
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