package com.avengers.red_aid.views

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.Navigation
import com.avengers.red_aid.R
import com.google.android.material.textfield.TextInputEditText

class LoginFragment() : Fragment() {

    var mTvGetOTP: Button? = null
    var mMobileNumber: EditText? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = Navigation.findNavController(view)
        mTvGetOTP = view.findViewById<Button>(R.id.btnOTP)
        mMobileNumber = view.findViewById<TextInputEditText>(R.id.etMobileNumber)
        mTvGetOTP?.setOnClickListener {
            navController.navigate(R.id.action_loginFragment_to_otpFragment)
        }
        mMobileNumber!!.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                if (s.length>=10) {
                    mTvGetOTP!!.isClickable = true
                    mTvGetOTP!!.setBackgroundColor(mTvGetOTP!!.resources.getColor(R.color.red_aid_red_700))
                } else {
                    mTvGetOTP!!.isClickable = false
                    mTvGetOTP!!.setBackgroundColor(mTvGetOTP!!.resources.getColor(R.color.red_aid_red_200))
                }
            }
        })
    }

}