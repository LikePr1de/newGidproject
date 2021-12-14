package com.example.database

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.itemview.view.*

class MyViewHolder(itemview:View):RecyclerView.ViewHolder(itemview) {
    fun populatemodel(user: User){
        itemView.tvname.text = user.firstName
        itemView.tvlastname.text = user.lastName
    }
}