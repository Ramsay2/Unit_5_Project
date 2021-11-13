package com.avengers.red_aid.views.Appointment

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.avengers.red_aid.R

class BloodReqHolder  (val view: View, val listener: BloodReqListener): RecyclerView.ViewHolder(view) {

    private var Img: ImageView

    init {
        Img=view.findViewById(R.id.ivbbreq);
    }
    fun setdata(model:BloodReqModel){
        Img.setImageResource(model.getImage())

        Img.setOnClickListener {
            listener.onitemclicked(adapterPosition,model)
        }
    }


}