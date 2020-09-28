package com.shahzaib.viewpager

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.shahzaib.viewpager.Tabs.*
import kotlin.math.round

class ViewPagerAdapter (fm: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fm, lifecycle) {
    private var tab1 = Tab1()
    private var tab2 = Tab2()
    private var tab3 = Tab3()
    private var tab4 = Tab4()
    private var tab5 = Tab5()
    private var tab6 = Tab6()
    private var tab7 = Tab7()

    private var maxPixels = 1080

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

    fun pageAnimation (pageNumber: Int, positionOffset: Float, positionOffsetPixels: Int) {
        if (round(positionOffset*100).toInt() == 100)
        {
            maxPixels = positionOffsetPixels
            Log.i("OnPage", "maxPixels: $maxPixels")
        }

        if (pageNumber == 0) {
            tab1.animateImages(positionOffset, positionOffsetPixels)
            tab1.animateText(positionOffset, -positionOffsetPixels)
            // Handles incoming animations for the incoming page
            tab2.animateImages(1 - positionOffset, maxPixels - positionOffsetPixels)
            tab2.animateText(1 - positionOffset, maxPixels - positionOffsetPixels)
        }
        else if (pageNumber == 1) {
            tab2.animateImages(positionOffset, positionOffsetPixels)
            tab2.animateText(positionOffset, -positionOffsetPixels)
            // Handles incoming animations for the incoming page
            tab3.animateImages(1 - positionOffset, maxPixels - positionOffsetPixels)
            tab3.animateText(1 - positionOffset, maxPixels - positionOffsetPixels)
        }
        else if (pageNumber == 2) {
            tab3.animateImages(positionOffset, positionOffsetPixels)
            tab3.animateText(positionOffset, -positionOffsetPixels)
            // Handles incoming animations for the incoming page
            tab4.animateImages(1 - positionOffset, maxPixels - positionOffsetPixels)
            tab4.animateText(1 - positionOffset, maxPixels - positionOffsetPixels)
        }
        else if (pageNumber == 3) {
            tab4.animateImages(positionOffset, positionOffsetPixels)
            tab4.animateText(positionOffset, -positionOffsetPixels)
            // Handles incoming animations for the incoming page
            tab5.animateImages(1 - positionOffset, maxPixels - positionOffsetPixels)
            tab5.animateText(1 - positionOffset, maxPixels - positionOffsetPixels)
        }
        else if (pageNumber == 4) {
            tab5.animateImages(positionOffset, positionOffsetPixels)
            tab5.animateText(positionOffset, -positionOffsetPixels)
            // Handles incoming animations for the incoming page
            tab6.animateImages(1 - positionOffset, maxPixels - positionOffsetPixels)
            tab6.animateText(1 - positionOffset, maxPixels - positionOffsetPixels)
        }
        else if (pageNumber == 5) {
            tab6.animateImages(positionOffset, positionOffsetPixels)
            tab6.animateText(positionOffset, -positionOffsetPixels)
            // Handles incoming animations for the incoming page
            tab7.animateImages(1 - positionOffset, maxPixels - positionOffsetPixels)
            tab7.animateText(1 - positionOffset, maxPixels - positionOffsetPixels)
        }
        else {
            tab7.animateImages(positionOffset, positionOffsetPixels)
            tab7.animateText(positionOffset, -positionOffsetPixels)
        }
    }
}