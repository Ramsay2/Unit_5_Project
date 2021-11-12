package com.avengers.red_aid.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.fragment.app.Fragment
import com.avengers.red_aid.R
import com.avengers.red_aid.databinding.FragmentCheckEligibilityBinding
import kotlinx.android.synthetic.main.fragment_check_eligibility.*

class CheckEligibilityFragment : Fragment() {
    private lateinit var checkEligibilityFragment: FragmentCheckEligibilityBinding
    private lateinit var lastBloodDonatedArray: Array<String>

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
        boxColor()

    }

    private fun lastBloodDonation(view: View) {
        lastBloodDonatedArray = resources.getStringArray(R.array.LastBloodDonation)
        val lastBlood = view.resources.getStringArray(R.array.LastBloodDonation)
        val arrayAdapter = context?.let {
            ArrayAdapter(it, R.layout.dropdown_layout, lastBlood)
        }
        val autocompleteTV = view.findViewById<AutoCompleteTextView>(R.id.etLastBloodDonation)
        autocompleteTV?.setAdapter(arrayAdapter)

    }

    private fun tattoo(view: View) {
        val tattoo = view.resources.getStringArray(R.array.Tattoo)
        val arrayAdapter = context?.let {
            ArrayAdapter(it, R.layout.dropdown_layout, tattoo)
        }
        val autocompleteTV = view.findViewById<AutoCompleteTextView>(R.id.tvTattoo)
        autocompleteTV?.setAdapter(arrayAdapter)
    }

    private fun boxColor() {
        checkEligibilityFragment.apply {
            btnCheck.isCheckable = true
            if (btnCheck.isCheckable) {
                btnCheck.setOnClickListener {

                }
            }
            etLastBloodDonation.setOnClickListener {

                ddLastBlood.boxBackgroundColor =
                    ddLastBlood.context.resources.getColor(R.color.red_aid_green_100)
            }

            tvTattoo.setOnClickListener {

                ddTattoo.boxBackgroundColor =
                    ddTattoo.context.resources.getColor(R.color.red_aid_green_100)
            }
            etMedicalCondition.setOnClickListener {

                tvMedicalIssue.boxBackgroundColor =
                    tvMedicalIssue.context.resources.getColor(R.color.red_aid_green_100)
            }
            checkbox.setOnClickListener {
                if (checkbox.isChecked)
                    btnCheck.setBackgroundColor(btnCheck.context.resources.getColor(R.color.red_aid_red_700))
                else
                    btnCheck.setBackgroundColor(btnCheck.context.resources.getColor(R.color.red_aid_red_200))

            }

            var checkLactation = 1
            var checkPregnancy = 1
            btnLactation.setOnClickListener {
                checkLactation = if(checkLactation == 1){
                    btnLactation.setBackgroundColor(resources.getColor(R.color.red_aid_green_500))
                    0
                }else{
                    btnLactation.setBackgroundColor(resources.getColor(R.color.red_aid_green_100))
                    1
                }

                btnPregnancy.setBackgroundColor(resources.getColor(R.color.red_aid_green_100))
            }

            btnPregnancy.setOnClickListener {
                checkPregnancy = if(checkPregnancy== 1){
                    btnPregnancy.setBackgroundColor(resources.getColor(R.color.red_aid_green_500))
                    0
                }else{
                    btnPregnancy.setBackgroundColor(resources.getColor(R.color.red_aid_green_100))
                    1
                }
                btnLactation.setBackgroundColor(resources.getColor(R.color.red_aid_green_100))
            }

        }
    }

}