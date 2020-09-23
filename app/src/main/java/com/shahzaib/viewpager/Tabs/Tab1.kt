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
        binding!!.screen1Layout.visibility = View.VISIBLE
        Log.e(TAG,"onResume Previous Position:$previousPosition, Current Position:$currentPosition")
    }

    override fun onPause() {
        binding!!.screen1Layout.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.outgoing_left_animation))
        binding!!.screen1Layout.visibility = View.GONE
        Log.e(TAG, "onPause")
        super.onPause()
    }

    fun startAnimation() {
        if(binding != null) {
            if (previousPosition > currentPosition)
            {
                binding!!.screen1Layout.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.incoming_left_animation))
            }
            else
                binding!!.screen1Layout.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.incoming_right_animation))
        }
    }

    fun outgoingAnimation() {
        if (previousPosition > currentPosition){
//            binding!!.screen1Layout.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.outgoing_left_animation))
            binding!!.background.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.slide_left_rotate_anti))
            binding!!.planner.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.slide_out_left))
            binding!!.man.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.slide_left_man))
        }
        else
            binding!!.screen1Layout.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.outgoing_right_animation))
    }
}