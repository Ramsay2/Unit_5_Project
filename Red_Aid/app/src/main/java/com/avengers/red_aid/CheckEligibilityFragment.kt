package com.avengers.red_aid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.avengers.red_aid.databinding.FragmentCheckEligibilityBinding

class CheckEligibilityFragment : Fragment() {
  private lateinit var checkEligibilityFragment: FragmentCheckEligibilityBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        checkEligibilityFragment = FragmentCheckEligibilityBinding.inflate(layoutInflater)


        return checkEligibilityFragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lastBloodDonation(view)
        tattoo(view)
    }

    private fun lastBloodDonation(view: View){
        val lastBlood = view.resources.getStringArray(R.array.LastBloodDonation)
        val arrayAdapter = context?.let { ArrayAdapter(it,R.layout.dropdown_layout,lastBlood) }
        val autocompleteTV = view.findViewById<AutoCompleteTextView>(R.id.etLastBloodDonation)
        autocompleteTV?.setAdapter(arrayAdapter)
    }

    private fun tattoo(view: View){
        val tattoo = view.resources.getStringArray(R.array.Tattoo)
        val arrayAdapter = context?.let { ArrayAdapter(it,R.layout.dropdown_layout,tattoo) }
        val autocompleteTV = view.findViewById<AutoCompleteTextView>(R.id.tvTattoo)
        autocompleteTV?.setAdapter(arrayAdapter)
    }

}