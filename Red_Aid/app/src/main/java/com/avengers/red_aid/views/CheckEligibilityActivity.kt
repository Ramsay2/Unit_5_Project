package com.avengers.red_aid.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.avengers.red_aid.databinding.ActivityCheckEligibilityBinding

class CheckEligibilityActivity : AppCompatActivity() {
    private lateinit var checkEligibilityActivity: ActivityCheckEligibilityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkEligibilityActivity= ActivityCheckEligibilityBinding.inflate(layoutInflater)
        setContentView(checkEligibilityActivity.root)


    }
}