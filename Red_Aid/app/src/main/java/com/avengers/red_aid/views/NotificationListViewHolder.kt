package com.avengers.red_aid.views

import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.avengers.red_aid.R

class NotificationListViewHolder(itemView: View, val chatItemClickListener: ChatItemClickListener) : RecyclerView.ViewHolder(itemView) {

    val mTvName = itemView.findViewById<TextView>(R.id.tvNotificationName)
    val mCvCard = itemView.findViewById<RelativeLayout>(R.id.cvCardNotification)

    fun setData(name: String) {

        mTvName.text = "$name accepted your request and sent you a message."
        mCvCard.setOnClickListener {
            chatItemClickListener.onItemClicked()
        }

    }
}