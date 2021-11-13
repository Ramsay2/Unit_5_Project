package com.avengers.red_aid.views

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.fragment.app.Fragment
import com.avengers.red_aid.R
import com.avengers.red_aid.databinding.FragmentRequestBloodBinding
import kotlinx.android.synthetic.main.fragment_request_blood.*


class RequestBloodFragment : Fragment() {
    private lateinit var requestBloodBinding: FragmentRequestBloodBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        requestBloodBinding = FragmentRequestBloodBinding.inflate(layoutInflater)
        return requestBloodBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        color()
        bloodGroup(view)
        requestBloodBinding.apply {
            etAddress.addTextChangedListener(object : TextWatcher {

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
                        btnCheck.isClickable = true
                        btnCheck.setBackgroundColor(btnCheck.resources.getColor(R.color.red_aid_red_700))
                    } else {
                        btnCheck.isClickable = false
                        btnCheck.setBackgroundColor(btnCheck.resources.getColor(R.color.red_aid_red_200))
                    }
                }
            })

        }
    }

    private fun bloodGroup(view: View) {
        val group = view.resources.getStringArray(R.array.BloodGroup)
        val arrayAdapter = context?.let {
            ArrayAdapter(it, R.layout.dropdown_layout, group)
        }
        val autocompleteTV = view.findViewById<AutoCompleteTextView>(R.id.etBloodGroup)
        autocompleteTV?.setAdapter(arrayAdapter)
    }

    private fun color() {
        var blood = 1
        var plasma = 1
        var platelets = 1
        btnBlood.setOnClickListener {
            blood = if (blood == 1) {
                btnBlood.setBackgroundColor(resources.getColor(R.color.red_aid_green_500))
                0
            } else {
                btnBlood.setBackgroundColor(resources.getColor(R.color.red_aid_green_100))
                1
            }

            btnPlasma.setBackgroundColor(resources.getColor(R.color.red_aid_green_100))
            btnPlatelets.setBackgroundColor(resources.getColor(R.color.red_aid_green_100))
        }
        btnPlasma.setOnClickListener {
            plasma = if (plasma == 1) {
                btnPlasma.setBackgroundColor(resources.getColor(R.color.red_aid_green_500))
                0
            } else {
                btnPlasma.setBackgroundColor(resources.getColor(R.color.red_aid_green_100))
                1
            }

            btnBlood.setBackgroundColor(resources.getColor(R.color.red_aid_green_100))
            btnPlatelets.setBackgroundColor(resources.getColor(R.color.red_aid_green_100))
        }
        btnPlatelets.setOnClickListener {
            platelets = if (platelets == 1) {
                btnPlatelets.setBackgroundColor(resources.getColor(R.color.red_aid_green_500))
                0
            } else {
                btnPlatelets.setBackgroundColor(resources.getColor(R.color.red_aid_green_100))
                1
            }

            btnBlood.setBackgroundColor(resources.getColor(R.color.red_aid_green_100))
            btnPlasma.setBackgroundColor(resources.getColor(R.color.red_aid_green_100))
        }


    }

}