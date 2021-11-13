package com.avengers.red_aid.views

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.avengers.red_aid.CheckEligibilityActivity
import com.avengers.red_aid.R

class HomeFragment : Fragment() {

    var mtvText :ImageView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mtvText = view.findViewById(R.id.tvText)
        mtvText?.setOnClickListener {
            val intent = Intent(context,CheckEligibilityActivity::class.java)
            startActivity(intent)
        }

    }

}