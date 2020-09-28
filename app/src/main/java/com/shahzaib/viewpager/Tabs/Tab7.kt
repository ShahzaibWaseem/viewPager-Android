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

    fun animate(positionOffset: Float, positionOffsetPixels: Int) {
        binding.background.translationX = positionOffsetPixels.toFloat() * 0.6F
        binding.background.alpha = 1.0F - positionOffset * 2

        binding.plant.translationX = positionOffsetPixels.toFloat() * 0.2F
        binding.plant.alpha = 1.0F - positionOffset * 2

        binding.lady.translationX =  positionOffsetPixels.toFloat() * 0.6F
        binding.lady.alpha = 1.0F - positionOffset * 2
    }
}