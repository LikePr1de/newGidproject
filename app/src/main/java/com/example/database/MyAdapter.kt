package com.example.database

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyAdapter:RecyclerView.Adapter<MyViewHolder>() {

    var model:MutableList<User> = mutableListOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view:View = LayoutInflater.from(parent.context).inflate(R.layout.itemview, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.populatemodel(model[position])
    }

    override fun getItemCount(): Int  = model.size

}