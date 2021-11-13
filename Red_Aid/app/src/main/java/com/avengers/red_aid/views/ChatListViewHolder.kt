package com.avengers.red_aid.views

import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.avengers.red_aid.R

class ChatListViewHolder(itemView: View, val chatItemClickListener: ChatItemClickListener) : RecyclerView.ViewHolder(itemView) {

    val mTvName = itemView.findViewById<TextView>(R.id.tvChatName)
    val mCvCard = itemView.findViewById<RelativeLayout>(R.id.cvCardChat)

    fun setData(name: String) {

        mTvName.text = name
        mCvCard.setOnClickListener {
            chatItemClickListener.onItemClicked()
        }

    }
}