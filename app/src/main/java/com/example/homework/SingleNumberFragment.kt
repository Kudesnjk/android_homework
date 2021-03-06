package com.example.homework

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

private const val SINGLE_NUMBER = "single_number"
private const val NUMBER_ARG = "number_arg"

class SingleNumber() : Fragment() {

    private var number: Int? = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        number = arguments?.getInt(NUMBER_ARG)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_single_number, container, false)
        val textView = view.findViewById<TextView>(R.id.single_number_text_view)
        restoreState(savedInstanceState)
        textView.text = number.toString()
        if (number?.rem(2) == 0) {
            textView.setTextColor(Color.RED)
        } else {
            textView.setTextColor(Color.BLUE)
        }
        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        number?.let { outState.putInt(SINGLE_NUMBER, it) }
        super.onSaveInstanceState(outState)
    }

    private fun restoreState(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            number = savedInstanceState.getInt(SINGLE_NUMBER)
        }
    }

    companion object {
        fun getInstance(number: Int): SingleNumber {
            return SingleNumber().apply {
                arguments = Bundle().apply {
                    putInt(NUMBER_ARG, number)
                }
            }
        }
    }
}