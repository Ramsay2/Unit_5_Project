package com.avengers.red_aid.views

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.avengers.red_aid.R
import com.example.newsbreeze_app.views.ChatListAdapter
import com.example.newsbreeze_app.views.NotificationListAdapter
import kotlinx.android.synthetic.main.fragment_chat.*
import kotlinx.android.synthetic.main.fragment_notifiation.*

class NotificationFragment : Fragment(), ChatItemClickListener {

    val list = ArrayList<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notifiation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list.add("Sonu")
        list.add("Sudhir")
        list.add("Vijay")
        list.add("Rahul")
        val adapter = NotificationListAdapter(list, this)
        val linearLayoutManager = LinearLayoutManager(context)
        recyclerViewNotification.adapter = adapter
        recyclerViewNotification.layoutManager = linearLayoutManager
    }

    override fun onItemClicked() {
        val intent = Intent(context, IndividiualChatActivity::class.java)
        startActivity(intent)
    }

}