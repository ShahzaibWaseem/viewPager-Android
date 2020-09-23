package com.shahzaib.viewpager.Tabs

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.shahzaib.viewpager.R
import com.shahzaib.viewpager.databinding.Tab6Binding

class Tab6: BaseFragment() {
    private lateinit var binding: Tab6Binding
    private val TAG = "Tab6"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        Log.e(TAG, "onCreateView")
        binding = Tab6Binding.inflate(layoutInflater)
        currentPosition = 5
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        binding.screen6Layout.visibility = View.VISIBLE
        Log.e(TAG,"onResume Previous Position:$previousPosition, Current Position:$currentPosition")
    }

    override fun onPause() {
        binding.screen6Layout.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.outgoing_left_animation))
        binding.screen6Layout.visibility = View.GONE
        Log.e(TAG, "onPause")
        super.onPause()
    }

    fun startAnimation() {
        if (previousPosition > currentPosition)
            binding.screen6Layout.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.incoming_left_animation))
        else
            binding.screen6Layout.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.incoming_right_animation))
    }

    fun outgoingAnimation() {
        if (previousPosition > currentPosition)
            binding.screen6Layout.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.outgoing_left_animation))
        else
            binding.screen6Layout.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.outgoing_right_animation))
    }
}