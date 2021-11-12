package com.avengers.red_aid.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.avengers.red_aid.R
import com.avengers.red_aid.databinding.FragmentPaymentBinding
import com.avengers.red_aid.databinding.FragmentTrackingBinding


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

    }
}