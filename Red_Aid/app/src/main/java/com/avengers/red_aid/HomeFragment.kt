package com.avengers.red_aid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.avengers.red_aid.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private  lateinit var homeBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeBinding = FragmentHomeBinding.inflate(layoutInflater)

        // Inflate the layout for this fragment
        return homeBinding.root
    }


}