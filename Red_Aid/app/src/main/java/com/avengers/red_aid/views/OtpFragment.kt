package com.avengers.red_aid.views

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.avengers.red_aid.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider

class OtpFragment : Fragment() {

    var mBtnVerify: Button? = null
    var mOtpField4: EditText? = null
    lateinit var auth: FirebaseAuth
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
        auth = FirebaseAuth.getInstance()
        val bundle = Bundle()
        val storedVerificationId = bundle.getString("storedVerificationId")


        mBtnVerify?.setOnClickListener {
            val otp = view.findViewById<EditText>(R.id.etOTP).text.trim().toString()
            if (otp.isNotEmpty()) {
                val credential: PhoneAuthCredential = PhoneAuthProvider.getCredential(
                    storedVerificationId.toString(), otp
                )
                signInWithPhoneAuthCredential(credential)
            } else {
                Toast.makeText(context, "Enter OTP", Toast.LENGTH_SHORT).show()
            }
        }


        mBtnVerify?.setOnClickListener {
            val intent = Intent(context, HomeActivity::class.java)
            startActivity(intent)
        }
        mOtpField4?.addTextChangedListener {
            object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    if (p0.toString().isNotEmpty()) {
                        mBtnVerify!!.isClickable = true
                        Log.d("TAG", "onTextChanged: changed")
                        mBtnVerify!!.setBackgroundColor(mBtnVerify!!.resources.getColor(R.color.red_aid_red_700))
                    } else {
                        mBtnVerify!!.isClickable = false
                        mBtnVerify!!.setBackgroundColor(mBtnVerify!!.resources.getColor(R.color.red_aid_red_200))
                    }
                }

                override fun afterTextChanged(p0: Editable?) {
                }

            }
        }
    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    val intent = Intent(context, HomeActivity::class.java)
                    startActivity(intent)

                } else {
                    // Sign in failed, display a message and update the UI
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        // The verification code entered was invalid
                        Toast.makeText(context, "Invalid OTP", Toast.LENGTH_SHORT).show()
                    }
                }
            }
    }

    private fun setViews(view: View) {
        mBtnVerify = view.findViewById(R.id.btnOTPFragmentVerify)
        mOtpField4 = view.findViewById(R.id.otpField4)
    }

}