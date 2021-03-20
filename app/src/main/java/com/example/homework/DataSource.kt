package com.example.homework

class DataSource(private val size: Int) {
    private var data: ArrayList<Int> = ArrayList()

    init {
        for (i in 0..size) {
            data.add(i)
        }
    }

    fun get(position: Int): Int {
        if (position < 0 || position >= data.size) {
            return -1
        }
        return data[position]
    }

    fun addElem(): Int {
        data.add(data.size)
        return data.size - 1
    }

    fun getElemsCount(): Int {
        return data.size
    }
}