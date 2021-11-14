package com.avengers.red_aid.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.avengers.red_aid.R
import com.avengers.red_aid.databinding.FragmentEligibleBinding


class EligibleFragment : Fragment() {

private lateinit var eligibleBinding: FragmentEligibleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        eligibleBinding = FragmentEligibleBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return eligibleBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)
        eligibleBinding.ivClose.setOnClickListener {
            navController.navigate(R.id.action_eligibleFragment_to_bloodbankFragment)
        }


    }

}