package com.shahzaib.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.shahzaib.viewpager.Tabs.*

class ViewPagerAdapter (fm: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fm, lifecycle) {
    private var tab1 = Tab1()
    private var tab2 = Tab2()
    private var tab3 = Tab3()
    private var tab4 = Tab4()
    private var tab5 = Tab5()
    private var tab6 = Tab6()
    private var tab7 = Tab7()

    override fun getItemCount(): Int {
        return 7
    }

    override fun createFragment(position: Int): Fragment {
        if (position == 0)
            return tab1
        else if (position == 1)
            return tab2
        else if (position == 2)
            return tab3
        else if (position == 3)
            return tab4
        else if (position == 4)
            return tab5
        else if (position == 5)
            return tab6
        else
            return tab7
    }

    fun selectedTab (previousTab: Int, currentPosition: Int) {
        if (currentPosition == 0) {
            tab1.setPrevious(previousTab)
            tab1.startAnimation()
        }
        else if (currentPosition == 1) {
            tab2.setPrevious(previousTab)
            tab2.startAnimation()
        }
        else if (currentPosition == 2) {
            tab3.setPrevious(previousTab)
            tab3.startAnimation()
        }
        else if (currentPosition == 3) {
            tab4.setPrevious(previousTab)
            tab4.startAnimation()
        }
        else if (currentPosition == 4) {
            tab5.setPrevious(previousTab)
            tab5.startAnimation()
        }
        else if (currentPosition == 5) {
            tab6.setPrevious(previousTab)
            tab6.startAnimation()
        }
        else {
            tab7.setPrevious(previousTab)
            tab7.startAnimation()
        }
    }

    fun unSelectedTab (currentPosition: Int) {
        if (currentPosition == 0) {
            tab1.outgoingAnimation()
        }
        else if (currentPosition == 1) {
            tab2.outgoingAnimation()
        }
        else if (currentPosition == 2) {
            tab3.outgoingAnimation()
        }
        else if (currentPosition == 3) {
            tab4.outgoingAnimation()
        }
        else if (currentPosition == 4) {
            tab5.outgoingAnimation()
        }
        else if (currentPosition == 5) {
            tab6.outgoingAnimation()
        }
        else {
            tab7.outgoingAnimation()
        }
    }
}