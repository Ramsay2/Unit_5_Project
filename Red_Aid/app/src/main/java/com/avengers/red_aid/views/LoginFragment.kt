package com.avengers.red_aid.views

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
import androidx.navigation.Navigation
import com.avengers.red_aid.R
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class LoginFragment() : Fragment() {

    var mTvGetOTP: Button? = null
    var mMobileNumber: EditText? = null

    // this stores the phone number of the user
    var number: String = ""

    // create instance of firebase auth
    lateinit var auth: FirebaseAuth

    // we will use this to match the sent otp from firebase
    lateinit var storedVerificationId: String
    lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
    private lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks


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
       // val navController = Navigation.findNavController(view)

        auth = FirebaseAuth.getInstance()
        signIn(view)
        mTvGetOTP = view.findViewById<Button>(R.id.btnOTP)
        mMobileNumber = view.findViewById<TextInputEditText>(R.id.etMobileNumber)
        mTvGetOTP?.setOnClickListener {
            login(view)
            // navController.navigate(R.id.action_loginFragment_to_otpFragment)
        }
        mMobileNumber!!.addTextChangedListener(object : TextWatcher {

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
                if (s.length >= 10) {
                    mTvGetOTP!!.isClickable = true
                    mTvGetOTP!!.setBackgroundColor(mTvGetOTP!!.resources.getColor(R.color.red_aid_red_700))
                } else {
                    mTvGetOTP!!.isClickable = false
                    mTvGetOTP!!.setBackgroundColor(mTvGetOTP!!.resources.getColor(R.color.red_aid_red_200))
                }
            }
        })
    }

    private fun signIn(view: View) {
        val navController = Navigation.findNavController(view)
        // Callback function for Phone Auth
        callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            // This method is called when the verification is completed
            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                //start otp fragment

                navController.navigate(R.id.action_loginFragment_to_otpFragment)
                Log.d("GFG", "onVerificationCompleted Success")
            }

            // Called when verification is failed add log statement to see the exception
            override fun onVerificationFailed(e: FirebaseException) {
                Log.d("GFG", "onVerificationFailed  $e")
            }

            // On code is sent by the firebase this method is called
            // in here we start a new activity where user can enter the OTP
            override fun onCodeSent(
                verificationId: String,
                token: PhoneAuthProvider.ForceResendingToken
            ) {
                Log.d("GFG", "onCodeSent: $verificationId")
                storedVerificationId = verificationId
                resendToken = token

                // Start a new activity using intent
                // also send the storedVerificationId using intent
                // we will use this id to send the otp back to firebase

                val bundle = Bundle()
                bundle.putString("storedVerificationId",storedVerificationId)
                Log.d("TAG", "onViewCreated: $storedVerificationId")
                navController.navigate(R.id.action_loginFragment_to_otpFragment,bundle)
                //start otp fragment
                /*val intent = Intent(applicationContext,OtpActivity::class.java)
                intent.putExtra("storedVerificationId",storedVerificationId)
                startActivity(intent)*/

            }
        }
    }

    private fun login(view: View) {
        number = view.findViewById<EditText>(R.id.etMobileNumber).text.trim().toString()

        // get the phone number from edit text and append the country cde with it
        if (number.isNotEmpty()) {
            number = "+91$number"
            sendVerificationCode(number)
        } else {
            Toast.makeText(context, "Enter mobile number", Toast.LENGTH_SHORT).show()
        }
    }

    // this method sends the verification code
    // and starts the callback of verification
    // which is implemented above in onCreate
    private fun sendVerificationCode(number: String) {
        val options = activity?.let {
            PhoneAuthOptions.newBuilder(auth)
                .setPhoneNumber(number) // Phone number to verify
                .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                .setActivity(it) // Activity (for callback binding)
                .setCallbacks(callbacks) // OnVerificationStateChangedCallbacks
                .build()
        }
        if (options != null) {
            PhoneAuthProvider.verifyPhoneNumber(options)
        }
        Log.d("GFG", "Auth started")
    }

}