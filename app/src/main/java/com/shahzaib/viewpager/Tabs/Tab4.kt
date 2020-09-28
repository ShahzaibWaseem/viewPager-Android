package com.shahzaib.viewpager.Tabs

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shahzaib.viewpager.databinding.Tab4Binding

class Tab4: BaseFragment() {
    private lateinit var binding: Tab4Binding
    private val TAG = "Tab4"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        Log.e(TAG, "onCreateView")
        binding = Tab4Binding.inflate(layoutInflater)
        currentPosition = 3
        return binding.root
    }

    fun animateImages(positionOffset: Float, positionOffsetPixels: Int) {
        binding.background.translationX = positionOffsetPixels.toFloat() * 0.6F
        binding.background.rotation = - positionOffsetPixels.toFloat() * 0.03F
        binding.background.alpha = 1.0F - positionOffset * 2

        binding.calendar.translationX = positionOffsetPixels.toFloat() * 0.6F
        binding.calendar.rotation = - positionOffsetPixels.toFloat() * 0.03F
        binding.calendar.alpha = 1.0F - positionOffset * 2

        binding.lady.translationX = positionOffsetPixels.toFloat() * 0.2F
        binding.lady.alpha = 1.0F - positionOffset * 2
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