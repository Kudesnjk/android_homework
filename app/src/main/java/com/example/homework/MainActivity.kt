package com.example.homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportFragmentManager.findFragmentById(R.id.fragment_wrapper) == null) {
            val fm = supportFragmentManager.beginTransaction()
            fm.add(R.id.fragment_wrapper, NumberList())
            fm.addToBackStack(null)
            fm.commit()
        }
    }
}