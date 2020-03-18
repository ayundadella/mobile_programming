package com.example.uts_mobile_terapan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter (val userList: ArrayList<User>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val user: User = userList[position]
        holder?.textViewNama?.text = user.nama
        holder?.textViewAlamat?.text = user.alamat
        holder?.textViewTtl?.text = user.ttl
        holder?.textViewNohp?.text = user.nohp
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.list_layout, parent, false)
        return ViewHolder(v)

    }

    override fun getItemCount(): Int {

        return userList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val textViewNama = itemView.findViewById(R.id.textViewNama) as TextView
        val textViewTtl = itemView.findViewById(R.id.textViewTtl) as TextView
        val textViewAlamat = itemView.findViewById(R.id.textViewAlamat) as TextView
        val textViewNohp = itemView.findViewById(R.id.textViewNohp) as TextView
    }
}