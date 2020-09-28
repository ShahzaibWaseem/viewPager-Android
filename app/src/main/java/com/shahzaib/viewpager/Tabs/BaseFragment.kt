package com.shahzaib.viewpager.Tabs

import android.content.Context
import android.util.Log
import androidx.fragment.app.Fragment

open class BaseFragment: Fragment() {
    lateinit var mContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }
}