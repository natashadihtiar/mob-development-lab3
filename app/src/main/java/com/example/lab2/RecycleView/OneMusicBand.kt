package com.example.lab2.RecycleView

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lab2.MusicBand
import com.example.lab2.R
import kotlinx.android.synthetic.main.activity_one_people.*

class OneMusicBand : AppCompatActivity() {

    @Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_people)
        val intent = Intent(this, Lab3RecyclerView::class.java)

        // Получение данных
        val position: Int = getIntent().getIntExtra("position", 0)
        val list = getIntent().getParcelableArrayListExtra<MusicBand>("list")

        title = list[position].name
        //Установка данных о группе
        imageView.setImageResource(list[position].avatarId)
        fioText.text = list[position].name
        stateText.text = "Страна: " + list[position].state
        yearText.text = "Год создания: " + list[position].year.toString()
        textView.text = "Информация о группе: " + list[position].about

        //Создание кнопки
        back.setOnClickListener {
            startActivity(intent)
        }
    }


}
