package com.example.homework

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NumberAdapter(private val data: DataSource, private val listener: NumberClickListener) : RecyclerView.Adapter<NumberViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.number_element, parent, false)
        return NumberViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        holder.bind(data.get(position))
    }

    override fun getItemCount(): Int {
        return data.getElemsCount()
    }
}