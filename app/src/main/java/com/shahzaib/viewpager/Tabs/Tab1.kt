package com.shahzaib.viewpager.Tabs

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.shahzaib.viewpager.R
import com.shahzaib.viewpager.databinding.Tab1Binding

class Tab1: BaseFragment() {
    private var binding: Tab1Binding? = null
    private val TAG = "Tab1"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        Log.e(TAG, "onCreateView")
        binding = Tab1Binding.inflate(layoutInflater)
        currentPosition = 0
        return binding!!.root
    }

    override fun onResume() {
        super.onResume()
        binding!!.tabText.visibility = View.VISIBLE
        Log.e(TAG,"onResume Previous Position:$previousPosition, Current Position:$currentPosition")
    }

    override fun onPause() {
        binding!!.tabText.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.outgoing_left_animation))
        binding!!.tabText.visibility = View.GONE
        Log.e(TAG, "onPause")
        super.onPause()
    }

    fun startAnimation() {
        if(binding != null) {
            if (previousPosition > currentPosition)
                binding!!.tabText.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.incoming_left_animation))
            else
                binding!!.tabText.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.incoming_right_animation))
        }
    }

    fun outgoingAnimation() {
        if (previousPosition > currentPosition)
            binding!!.tabText.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.outgoing_left_animation))
        else
            binding!!.tabText.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.outgoing_right_animation))
    }
}