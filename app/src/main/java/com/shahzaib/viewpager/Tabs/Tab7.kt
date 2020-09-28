package com.shahzaib.viewpager.Tabs

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shahzaib.viewpager.databinding.Tab7Binding

class Tab7: BaseFragment() {
    private lateinit var binding: Tab7Binding
    private val TAG = "Tab7"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        Log.e(TAG, "onCreateView")
        binding = Tab7Binding.inflate(layoutInflater)
        currentPosition = 6
        return binding.root
    }

    fun animateImages(positionOffset: Float, positionOffsetPixels: Int) {
        binding.background.translationX = positionOffsetPixels.toFloat() * 0.6F
        binding.background.alpha = 1.0F - positionOffset * 2

        binding.plant.translationX = positionOffsetPixels.toFloat() * 0.2F
        binding.plant.alpha = 1.0F - positionOffset * 2

        binding.lady.translationX =  positionOffsetPixels.toFloat() * 0.6F
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