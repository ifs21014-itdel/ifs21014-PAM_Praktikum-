package com.ifs21014.pampraktikum8

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmailAdapter (
    private val context : Context,
    private val gmail : MutableList<Gmail>,
    val listener:(Gmail) -> Unit
) :  RecyclerView.Adapter<EmailAdapter.GmailViewHolder>(){

    class GmailViewHolder(view: View): RecyclerView.ViewHolder(view){
        val img = view.findViewById<ImageView>(R.id.img_sender)
        val name = view.findViewById<TextView>(R.id.tv_item_pengirim)
        val waktu = view.findViewById<TextView>(R.id.tv_item_time)
        val pesan = view.findViewById<TextView>(R.id.tv_item_message)

        fun bindView(destination: Gmail, listener: (Gmail) -> Unit) {
            img.setImageResource(destination.img)
            name.text = destination.pengirim
            waktu.text = destination.waktu
            pesan.text = destination.pesan
            itemView.setOnClickListener {
                listener(destination)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GmailViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_gmail, parent, false)
        return GmailViewHolder(view)
    }
    override fun onBindViewHolder(holder: GmailViewHolder, position: Int) {
        val currentDestination = gmail[position]
        holder.bindView(currentDestination, listener)
    }
    override fun getItemCount(): Int {
        return gmail.size
    }

}



