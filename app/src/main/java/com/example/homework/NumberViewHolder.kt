package com.example.homework

import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

interface NumberClickListener {
    fun onNumberClick(number: Int)
}

class NumberViewHolder(itemView: View, private val listener: NumberClickListener) :
        RecyclerView.ViewHolder(itemView) {
    private val number : TextView = itemView.findViewById(R.id.number_text_view)

    fun bind(num: Int) {
        number.text = num.toString()

        if (num % 2 == 0) {
            number.setTextColor(Color.RED)
        } else {
            number.setTextColor(Color.BLUE)
        }

        number.setOnClickListener {
            listener.onNumberClick(num)
        }
    }
}