package com.avengers.red_aid.views.Appointment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.avengers.red_aid.R

class BloodReqAdapter(val Reqlist:ArrayList<BloodReqModel>, val listener:BloodReqListener):
    RecyclerView.Adapter<BloodReqHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BloodReqHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.bloodreqlayout,parent,false)
        return BloodReqHolder(view,listener)
    }

    override fun onBindViewHolder(holder: BloodReqHolder, position: Int) {
        val appointment=Reqlist.get(position)
        holder.setdata(appointment)    }

    override fun getItemCount(): Int {
return Reqlist.size   }


}