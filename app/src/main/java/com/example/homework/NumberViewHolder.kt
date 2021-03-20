package com.example.homework

import android.graphics.Color
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class NumberViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val number : TextView = itemView.findViewById(R.id.number_text_view)

    fun bind(num: Int) {
        number.text = num.toString()

        if (num % 2 == 0) {
            number.setTextColor(Color.RED)
        } else {
            number.setTextColor(Color.BLUE)
        }

        number.setOnClickListener(View.OnClickListener {
            val fm = (this.number.context as AppCompatActivity).supportFragmentManager.beginTransaction()
            fm.replace(R.id.fragment_wrapper, SingleNumber.getInstance(num))
            fm.addToBackStack(null)
            fm.commit()
        })
    }
}