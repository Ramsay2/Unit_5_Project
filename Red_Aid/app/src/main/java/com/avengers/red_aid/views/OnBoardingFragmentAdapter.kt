package com.avengers.red_aid.views

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class OnBoardingFragmentAdapter(fragmentActivity: FragmentActivity?) :
    FragmentStateAdapter(fragmentActivity!!) {
    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return OnBoardingFragment1()
            1 -> return OnBoardingFragment2()
            2 -> return OnBoardingFragment3()
            3 -> return OnBoardingFragment4()
        }
        return OnBoardingFragment1()
    }

    override fun getItemCount(): Int {
        return 4
    }
}