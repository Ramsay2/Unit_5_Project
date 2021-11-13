package com.avengers.red_aid.views.Appointment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.avengers.red_aid.R

class AppointmentAdapter(val Appointlist:ArrayList<AppointmentModel>, val listener:AppointListener):
    RecyclerView.Adapter<AppointmentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppointmentViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.appointmentlayout,parent,false)
        return AppointmentViewHolder(view,listener)    }

    override fun onBindViewHolder(holder: AppointmentViewHolder, position: Int) {
        val appointment=Appointlist.get(position)
        holder.setdata(appointment)
    }

    override fun getItemCount(): Int {
        return Appointlist.size
    }
}