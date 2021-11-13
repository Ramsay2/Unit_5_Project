package com.avengers.red_aid.views

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.avengers.red_aid.R
import com.avengers.red_aid.databinding.FragmentPaymentBinding
import com.avengers.red_aid.databinding.FragmentTrackingBinding
import com.avengers.red_aid.databinding.FragmentTrackingDonationBinding


class TrackingDonationFragment : Fragment() {

    private lateinit var trackingDonationFragment: FragmentTrackingDonationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        trackingDonationFragment = FragmentTrackingDonationBinding.inflate(layoutInflater)

        return trackingDonationFragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        trackingDonationFragment.bottomNavigation.setOnClickListener {
            val intent = Intent(activity, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}