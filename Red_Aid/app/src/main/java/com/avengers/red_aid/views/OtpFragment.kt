package com.avengers.red_aid.views

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import com.avengers.red_aid.R

class OtpFragment : Fragment() {

    var mBtnVerify: Button? = null
    var mOtpField4: EditText? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_otp, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViews(view)
        mBtnVerify?.setOnClickListener {
            val intent = Intent(context, HomeActivity::class.java)
            startActivity(intent)
        }
        mOtpField4!!.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                if (s.isNotEmpty()) {
                    mBtnVerify!!.isClickable = true
                    mBtnVerify!!.setBackgroundColor(mBtnVerify!!.resources.getColor(R.color.red_aid_red_700))
                } else {
                    mBtnVerify!!.isClickable = false
                    mBtnVerify!!.setBackgroundColor(mBtnVerify!!.resources.getColor(R.color.red_aid_red_200))
                }
            }
        })
    }

    private fun setViews(view: View) {
        mBtnVerify = view.findViewById(R.id.btnOTPFragmentVerify)
        mOtpField4 = view.findViewById(R.id.otpField4)
    }

}