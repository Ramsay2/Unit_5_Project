package com.avengers.red_aid.views.Appointment

import android.app.DatePickerDialog
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.avengers.red_aid.R
import kotlinx.android.synthetic.main.activity_booking.*
import java.text.SimpleDateFormat
import java.util.*

class BookingAct : AppCompatActivity() {
    private lateinit var tvdate: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)
        tvdate=findViewById(R.id.tvdate)
        var ivback: ImageView =findViewById(R.id.ivback)

        val calender= Calendar.getInstance()
        val datepick= DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            calender.set(Calendar.YEAR,year)
            calender.set(Calendar.MONTH,month)
            calender.set(Calendar.DAY_OF_MONTH,dayOfMonth)
            updatelable(calender)

        }
        tvdate.setOnClickListener {
            DatePickerDialog(this,datepick,calender.get(Calendar.YEAR),calender.get(Calendar.MONTH),calender.get(
                Calendar.DAY_OF_MONTH))
                .show()


        }
        ivback.setOnClickListener {
            val intent= Intent(this,BloodbankFragment::class.java)
            startActivity(intent)
        }
        btnbook.setOnClickListener {

        }
        var boo:Boolean=false

        tvtimes1.setOnClickListener {
            if (!boo){
                tvtimes1.setBackgroundColor(Color.RED)
                boo=true
            }else{
                tvtimes1.setBackgroundColor(Color.WHITE)
                boo=false
            }
        }
        tvtimes2.setOnClickListener {
            if (!boo){
                tvtimes2.setBackgroundColor(Color.RED)
                boo=true
            }else{
                tvtimes2.setBackgroundColor(Color.WHITE)
                boo=false
            }
        }
        tvtimes3.setOnClickListener {
            if (!boo){
                tvtimes3.setBackgroundColor(Color.RED)
                boo=true
            }else{
                tvtimes3.setBackgroundColor(Color.WHITE)
                boo=false
            }
        }
        tvtimes4.setOnClickListener {
            if (!boo){
                tvtimes4.setBackgroundColor(Color.RED)
                boo=true
            }else{
                tvtimes4.setBackgroundColor(Color.WHITE)
                boo=false
            }
        }
        tvtimes5.setOnClickListener {
            if (!boo){
                tvtimes5.setBackgroundColor(Color.RED)
                boo=true
            }else{
                tvtimes5.setBackgroundColor(Color.WHITE)
                boo=false
            }
        }
        tvtimes6.setOnClickListener {
            if (!boo){
                tvtimes6.setBackgroundColor(Color.RED)
                boo=true
            }else{
                tvtimes6.setBackgroundColor(Color.WHITE)
                boo=false
            }
        }
        tvtimes7.setOnClickListener {
            if (!boo){
                tvtimes7.setBackgroundColor(Color.RED)
                boo=true
            }else{
                tvtimes7.setBackgroundColor(Color.WHITE)
                boo=false
            }
        }
        tvtimes8.setOnClickListener {
            if (!boo){
                tvtimes8.setBackgroundColor(Color.RED)
                boo=true
            }else{
                tvtimes8.setBackgroundColor(Color.WHITE)
                boo=false
            }
        }
        tvtimes9.setOnClickListener {
            if (!boo){
                tvtimes9.setBackgroundColor(Color.RED)
                boo=true
            }else{
                tvtimes9.setBackgroundColor(Color.WHITE)
                boo=false
            }
        }
        btnbook.setOnClickListener {
            val intentt=Intent(this,Apoointbook::class.java)
            startActivity(intentt)
        }
    }

    private fun updatelable(calender: Calendar) {
        val myformat="dd/mm/yyyy"
        val sdf= SimpleDateFormat(myformat, Locale.UK)
        tvdate.setText(sdf.format(calender.time))

    }
}