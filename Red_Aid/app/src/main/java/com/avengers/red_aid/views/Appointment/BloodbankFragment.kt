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
import java.util.ArrayList

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BloodbankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BloodbankFragment : Fragment(R.layout.fragment_bloodbank),AppointListener {

    private lateinit var recyclerView: RecyclerView
    private val appointlist= ArrayList<AppointmentModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView= view?.findViewById(R.id.appointrecycle)!!
        buildlist( )
        recyclerview()

    }
    private fun buildlist(){
        val appoint1=AppointmentModel(R.drawable.card1)
        appointlist.add(appoint1)
        val appoint2=AppointmentModel(R.drawable.card2)
        appointlist.add(appoint2)
        val appoint3=AppointmentModel(R.drawable.card3)
        appointlist.add(appoint3)
        val appoint4=AppointmentModel(R.drawable.card1)
        appointlist.add(appoint4)
    }

    private fun recyclerview() {
        val appointadap = AppointmentAdapter(appointlist, this)
        val linearLayoutManager = LinearLayoutManager(context)
        recyclerView.setLayoutManager(linearLayoutManager)
        recyclerView.setAdapter(appointadap)
    }

    override fun onitemclicked(position: Int, model: AppointmentModel) {
        val intent= Intent(context,BookingAct::class.java)
        startActivity(intent)
    }



}