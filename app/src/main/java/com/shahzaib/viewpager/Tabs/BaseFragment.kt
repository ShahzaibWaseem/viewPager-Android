package com.shahzaib.viewpager.Tabs

import android.content.Context
import android.util.Log
import androidx.fragment.app.Fragment

open class BaseFragment: Fragment() {
    var currentPosition: Int = 0
    var previousPosition: Int = 0
    lateinit var mContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    fun setPrevious(previousPosition: Int) {
        Log.e("onResume", "setPrevious: $previousPosition")
        this.previousPosition = previousPosition
    }
}