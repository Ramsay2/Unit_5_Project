package com.avengers.red_aid.views.Appointment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.avengers.red_aid.R
import com.avengers.red_aid.views.TrackingDriverActivity
import kotlinx.android.synthetic.main.activity_get_blood.*

class GetBloodAct : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_blood)

        ivadd.setOnClickListener {
            val no=tvfunit.text as Int

            tvfunit.text= (no+1).toString()
        }

        btngetblood.setOnClickListener {
            val intent = Intent(this,TrackingDriverActivity::class.java)
            startActivity(intent)
        }
        ivsub.setOnClickListener {
            if(!tvfunit.text.equals(1)){
                var no=tvfunit.text as Int
                tvfunit.text= (no-1).toString()

            }
        }
    }
}