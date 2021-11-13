package com.avengers.red_aid.views.Appointment

class BloodReqModel (private var Image:Int) {


    fun BloodReqModel(image: Int) {
        Image = image
    }


    fun getImage(): Int {
        return Image
    }

}