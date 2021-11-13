package com.avengers.red_aid.views.Appointment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.avengers.red_aid.R
import kotlinx.android.synthetic.main.fragment_bloodrequest.*
import java.util.ArrayList


class BloodrequestFragment : Fragment(R.layout.fragment_bloodrequest),BloodReqListener {

    private lateinit var recyclerViewbb: RecyclerView
    private val appointlist= ArrayList<BloodReqModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewbb= view.findViewById(R.id.recyclebb)!!
        tvblbank.setOnClickListener {
      cvbbsel.visibility=View.VISIBLE

            tvneardonor.setOnClickListener {
                val txt1=tvneardonor.text
                tvblbank.text=txt1
                cvbbsel.visibility=View.GONE
            }
            tvnearbank.setOnClickListener {
                val txt2=tvneardonor.text
                tvblbank.text=txt2
                cvbbsel.visibility=View.GONE
            }
        }
        buildlist( )
        recyclerview()

    }
    private fun buildlist(){
        val appoint1=BloodReqModel(R.drawable.bbcard1)
        appointlist.add(appoint1)
        val appoint2=BloodReqModel(R.drawable.bbcard2)
        appointlist.add(appoint2)
        val appoint3=BloodReqModel(R.drawable.bbcard3)
        appointlist.add(appoint3)
        val appoint4=BloodReqModel(R.drawable.bbcard1)
        appointlist.add(appoint4)
    }

    private fun recyclerview() {
        val appointadap = BloodReqAdapter(appointlist, this)
        val linearLayoutManager = LinearLayoutManager(context)
        recyclerViewbb.setLayoutManager(linearLayoutManager)
        recyclerViewbb.setAdapter(appointadap)
    }


    override fun onitemclicked(position: Int, model: BloodReqModel) {
        val intent= Intent(context,GetBloodAct::class.java)
        startActivity(intent)
    }
}