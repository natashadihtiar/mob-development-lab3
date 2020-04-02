package com.example.lab2.ListView

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.example.lab2.MusicBand
import com.example.lab2.R
import kotlinx.android.synthetic.main.activity_one_people.*

class OneMusicBand : Activity() {

    @Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_people)
        val intent = Intent(this, Lab3ListView::class.java)

        // Получение данных
        val position: Int = getIntent().getIntExtra("position", 0)
        val list = getIntent().getParcelableArrayListExtra<MusicBand>("list")

        title = list[position].name
        //Установление данных
        imageView.setImageResource(list[position].avatarId)
        fioText.text = list[position].name
        stateText.text = "Стиль: " + list[position].state
        yearText.text = "Год создания: " + list[position].year.toString()
        textView.text = "Информация о группе: " + list[position].about

        // Создание кнопки
        back.setOnClickListener {
            startActivity(intent)
        }
    }
}
