package com.avengers.red_aid.views.Appointment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.avengers.red_aid.R
import kotlinx.android.synthetic.main.activity_get_blood.*

class GetBloodAct : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_blood)

        ivadd.setOnClickListener {
            var no=tvfunit.text as Int



            tvfunit.text= (no+1).toString()
        }
        ivsub.setOnClickListener {
            if(!tvfunit.text.equals(1)){
                var no=tvfunit.text as Int
                tvfunit.text= (no-1).toString()

            }
        }
    }
}