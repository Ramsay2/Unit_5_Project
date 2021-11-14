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
import androidx.fragment.app.Fragment
import com.avengers.red_aid.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider

class OtpFragment : Fragment() {

    var mBtnVerify: Button? = null
    var mOtpField6: EditText? = null

    private lateinit var auth: FirebaseAuth

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


        // get storedVerificationId from the intent
        val  storedVerificationId = arguments?.getString("storedVerificationId")


        Log.d("TAG", "onViewCreated: $storedVerificationId")

        // fill otp and call the on click on button
        view.findViewById<Button>(R.id.btnOTPFragmentVerify).setOnClickListener {
            val otp ="${view.findViewById<EditText>(R.id.otpField1).text.trim()}" +
                    "${view.findViewById<EditText>(R.id.otpField2).text.trim()}" +
                    "${view.findViewById<EditText>(R.id.otpField3).text.trim()}" +
                    "${view.findViewById<EditText>(R.id.otpField4).text.trim()}" +
                    "${view.findViewById<EditText>(R.id.otpField5).text.trim()}" +
                    "${view.findViewById<EditText>(R.id.otpField6).text.trim()}"

           // val otp = view.findViewById<EditText>(R.id.etOTP).text.trim().toString()
            if (otp.isNotEmpty()) {
                val credential: PhoneAuthCredential = PhoneAuthProvider.getCredential(
                    storedVerificationId.toString(), otp
                )
                signInWithPhoneAuthCredential(credential)
            } else {
                Toast.makeText(context, "Enter OTP", Toast.LENGTH_SHORT).show()
            }
        }


     /*   mBtnVerify?.setOnClickListener {
            val intent = Intent(context, HomeActivity::class.java)
            startActivity(intent)
        }*/
        mOtpField6!!.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
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
        mOtpField6 = view.findViewById(R.id.otpField6)
    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        activity?.let {
            auth.signInWithCredential(credential)
                .addOnCompleteListener(it) { task ->
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
    }
}