package com.avengers.red_aid.views

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.avengers.red_aid.databinding.FragmentTrackingBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class TrackingFragment : Fragment() {

    private lateinit var trackingFragment: FragmentTrackingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        trackingFragment = FragmentTrackingBinding.inflate(layoutInflater)

        return trackingFragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        trackingFragment.bottomNavigation.setOnNavigationItemSelectedListener(navListener)

    }

    private val navListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                com.avengers.red_aid.R.id.nav_home ->
                {
                    val intent = Intent(activity, HomeActivity::class.java)
                    startActivity(intent)
                }
                com.avengers.red_aid.R.id.nav_chats -> {
                    val intent = Intent(activity, HomeActivity::class.java)
                    startActivity(intent)
                }
                com.avengers.red_aid.R.id.nav_support ->{
                    val intent = Intent(activity, HomeActivity::class.java)
                    startActivity(intent)
                }
                com.avengers.red_aid.R.id.nav_notification -> {
                    val intent = Intent(activity, HomeActivity::class.java)
                    startActivity(intent)
                }
                else -> {
                    val intent = Intent(activity, HomeActivity::class.java)
                    startActivity(intent)
                }
            }
            false
        }
}