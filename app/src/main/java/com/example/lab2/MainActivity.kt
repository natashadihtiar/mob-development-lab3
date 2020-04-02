package com.example.lab2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.lab2.ListView.Lab3ListView
import com.example.lab2.RecycleView.Lab3RecyclerView

class MainActivity : Activity() { // Лабораторна робота 2. Явні наміри

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(view: View) {
        when ((view as Button).id) {
            // Использование ListView
            R.id.lab3_list_view -> startActivity(Intent(this, Lab3ListView::class.java))
            // Использование RecyclerView
            R.id.lab3_recycler_view -> startActivity(Intent(this, Lab3RecyclerView::class.java))
         }
    }
}
