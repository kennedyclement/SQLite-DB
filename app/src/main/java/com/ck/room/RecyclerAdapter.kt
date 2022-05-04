package com.ck.room

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    private var tittle = arrayOf("Android Version 1","Android Version 2","Android Version 3",
        "Android Version 4","Android Version 5","Android Version 6","Android Version 7","Android Version 8" ,
        "Android Version 9","Android Version 10","Android Version 11","Android Version 12","Android Version 13")

    private  var details = arrayOf("Cupcake and Donut","Eclair and Froyo","Gingerbread","Honeycomb",
        "IceCreamSandwich","Jelly Bean","Oreo", "Pie" ,"Android 9","Android 10","Android 11","Android 12","Android 13")

    private var marks = arrayOf("70","80","98","26","66","85","77","87","91","100","88","97","75")


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text =tittle[position]
        holder.address.text =details[position]
        holder.mark.text =marks[position]

    }

    override fun getItemCount(): Int {


        return tittle.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var name: TextView
        var address: TextView
        var mark: TextView

        init {
            name = itemView.findViewById(R.id.name_id)
            address = itemView.findViewById(R.id.address_id)
            mark = itemView.findViewById(R.id.mark_id)

        }

    }


}