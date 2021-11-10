package com.avengers.red_aid.views

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.avengers.red_aid.R

class OtpFragment : Fragment() {

    var mBtnVerify : Button? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_otp, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBtnVerify = view.findViewById(R.id.btnOTPFragmentVerify)
        mBtnVerify?.setOnClickListener {
            val intent = Intent(context, HomeActivity::class.java)
            startActivity(intent)
        }
    }

}