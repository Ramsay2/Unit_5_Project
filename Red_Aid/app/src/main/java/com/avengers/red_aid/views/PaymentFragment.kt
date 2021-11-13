package com.avengers.red_aid.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.avengers.red_aid.R
import com.avengers.red_aid.databinding.FragmentCheckEligibilityBinding
import com.avengers.red_aid.databinding.FragmentPaymentBinding


class PaymentFragment : Fragment() {
    private lateinit var paymentFragment: FragmentPaymentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        paymentFragment = FragmentPaymentBinding.inflate(layoutInflater)

        return paymentFragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}