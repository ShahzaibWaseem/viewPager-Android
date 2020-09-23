package com.shahzaib.viewpager

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator
import com.shahzaib.viewpager.databinding.DemoViewpagerActivityBinding

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

        binding.tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                mPreviousPosition = mSelectedPosition
                mSelectedPosition = tab.position
                Log.e("onTabSelected", "Previous: $mPreviousPosition Selected: $mSelectedPosition")
                mAdapter.selectedTab(mPreviousPosition, mSelectedPosition)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                mAdapter.unSelectedTab(tab.position)
            }

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

        binding.pager.adapter = mAdapter
        tabLayoutMediator.attach()
    }
}