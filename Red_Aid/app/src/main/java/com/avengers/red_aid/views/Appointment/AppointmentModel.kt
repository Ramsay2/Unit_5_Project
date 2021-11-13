package com.avengers.red_aid.views.Appointment

class AppointmentModel (private var Image:Int) {


    fun AppointmentModel(image: Int) {
        Image = image
    }


    fun getImage(): Int {
        return Image
    }

}