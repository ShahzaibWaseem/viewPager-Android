package com.shahzaib.viewpager

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.shahzaib.viewpager.databinding.DemoViewpagerActivityBinding
import kotlin.math.round

class DemoViewPagerActivity: AppCompatActivity() {
    private lateinit var binding: DemoViewpagerActivityBinding
    private lateinit var mAdapter: ViewPagerAdapter
    private lateinit var tabLayoutMediator: TabLayoutMediator
    private var mSelectedPosition: Int = 0
    private var mPreviousPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DemoViewpagerActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        mAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        binding.pager.offscreenPageLimit = 6

        tabLayoutMediator = TabLayoutMediator(binding.tabLayout, binding.pager) { _, position ->
            Log.e("TabLayout", "Mediator: Position: $position")
            mAdapter.createFragment(position)
        }

        var prevPosOffset: Float = 0F
        var previousSwipingDirection = "Left"
        binding.pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(pageNumber: Int, positionOffset: Float, positionOffsetPixels: Int) {
                mPreviousPosition = mSelectedPosition

//                mAdapter.incomingPage(mPreviousPosition, pageNumber, positionOffset, positionOffsetPixels)
                var swipingDirection = ""
                if (positionOffset == 0.0f)
                    swipingDirection = "Halt"
                else if (prevPosOffset > positionOffset)
                    swipingDirection = "Right"
                else
                    swipingDirection = "Left"

                Log.i("OnPageScrolled", "position: $pageNumber\tpositionOffset: ${round(positionOffset*100).toInt()}\tpositionOffsetPixels: $positionOffsetPixels\tswipingDirection: $swipingDirection")

                mAdapter.pageAnimation(pageNumber, positionOffset, positionOffsetPixels)


                mSelectedPosition = pageNumber
                prevPosOffset = positionOffset
                previousSwipingDirection = swipingDirection
            }

            override fun onPageSelected(position: Int) {}
        })

        binding.pager.adapter = mAdapter
        tabLayoutMediator.attach()
    }
}