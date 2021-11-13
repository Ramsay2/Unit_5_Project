package com.avengers.red_aid.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.avengers.red_aid.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class OnBoardingActivity : AppCompatActivity(), TabLayout.OnTabSelectedListener {
    private var mViewPager: ViewPager2? = null
    private var tabLayout: TabLayout? = null
    private var mTvSkip: TextView? = null
    private var mBtnNext: ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_on_boarding)

        initViews()
        setViewPagerAdapter()
        mTvSkip?.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initViews() {
        mViewPager = findViewById(R.id.viewPagerOnBoarding)
        tabLayout = findViewById(R.id.tabLayoutOnBoarding)
        mTvSkip = findViewById(R.id.tvOnBoardingSkip)
        mBtnNext = findViewById(R.id.btnOnBoardingNext)
    }

    private fun setViewPagerAdapter() {
        val fragmentAdapter = OnBoardingFragmentAdapter(this)
        mViewPager!!.adapter = fragmentAdapter
        TabLayoutMediator(
            tabLayout!!, mViewPager!!
        ) { tab, position -> }.attach()
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {
    }
}