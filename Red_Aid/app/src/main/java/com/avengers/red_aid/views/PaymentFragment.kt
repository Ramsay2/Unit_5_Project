package com.avengers.red_aid.views

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.avengers.red_aid.R
import com.avengers.red_aid.databinding.FragmentPaymentBinding
import com.avengers.red_aid.views.Appointment.Apoointbook


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
        paymentFragment.apply {
            tvDebitCardMenu.setOnClickListener {
            viewDebitCardMenuExpanded.visibility = View.VISIBLE
            }


            etCardCVV.addTextChangedListener(object : TextWatcher {

                override fun afterTextChanged(s: Editable) {}

                override fun beforeTextChanged(s: CharSequence, start: Int,
                                               count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence, start: Int,
                                           before: Int, count: Int) {
                    if (s.isNotEmpty()) {
                        btnPay.isClickable = true
                        btnPay.setBackgroundColor(btnPay.resources.getColor(R.color.red_aid_red_700))
                    } else {
                        btnPay.isClickable = false
                        btnPay.setBackgroundColor(btnPay.resources.getColor(R.color.red_aid_red_200))
                    }
                }
            })

            btnPay.setOnClickListener {

                val intent = Intent(context, PaymentSuccessfulActivity::class.java)
                startActivity(intent)
            }

        }



    }
}