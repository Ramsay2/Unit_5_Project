package com.avengers.red_aid.views.Appointment

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.avengers.red_aid.R
import com.avengers.red_aid.views.TrackDonationActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Apoointbook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apoointbook)


    }

    override fun onResume() {
        super.onResume()

        CoroutineScope(Dispatchers.Main).launch {
            delay(3000)
            val intent = Intent(this@Apoointbook, TrackDonationActivity::class.java)
            startActivity(intent)
        }


    }
}