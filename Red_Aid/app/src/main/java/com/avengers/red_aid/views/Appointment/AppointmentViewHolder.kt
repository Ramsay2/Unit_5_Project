package com.avengers.red_aid.views.Appointment

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.avengers.red_aid.R

class AppointmentViewHolder (val view: View, val listener: AppointListener): RecyclerView.ViewHolder(view) {

    private var Img: ImageView

    init {
        Img=view.findViewById(R.id.ivappoint);
    }
    fun setdata(model:AppointmentModel){
        Img.setImageResource(model.getImage())

        Img.setOnClickListener {
            listener.onitemclicked(adapterPosition,model)
        }
    }


}