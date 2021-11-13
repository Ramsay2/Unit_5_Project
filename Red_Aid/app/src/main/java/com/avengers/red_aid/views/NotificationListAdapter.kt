package com.example.newsbreeze_app.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.avengers.red_aid.R
import com.avengers.red_aid.views.ChatItemClickListener
import com.avengers.red_aid.views.ChatListViewHolder
import com.avengers.red_aid.views.NotificationListViewHolder

class NotificationListAdapter(val list: List<String?>?, val chatItemClickListener: ChatItemClickListener) :
    RecyclerView.Adapter<NotificationListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.notification_item_layout, parent, false)
        return NotificationListViewHolder(view, chatItemClickListener)
    }

    override fun onBindViewHolder(holder: NotificationListViewHolder, position: Int) {
        val name = list!![position]!!
        holder.setData(name)
    }

    override fun getItemCount(): Int {
        return list!!.size
    }
}