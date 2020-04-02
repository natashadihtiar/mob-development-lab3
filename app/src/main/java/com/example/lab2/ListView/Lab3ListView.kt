package com.example.lab2.ListView

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.lab2.MainActivity
import com.example.lab2.MusicBand
import com.example.lab2.R
import kotlinx.android.synthetic.main.activity_lab3_list_view.*

class Lab3ListView : AppCompatActivity() {

    //Создание объекта
    private var band: MutableList<MusicBand> = ArrayList()

    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab3_list_view)
        title = "Lab3 ListView"

        //Добавление информации о группах
        val list: ListView = list_view // Віджет ListView
        band.add(MusicBand(R.drawable.imagine_dragons, "Imagine Dragons", "rock", 2012, "«Imagine Dragons» — американская инди-рок-группа, образованная в 2008 году в городе Лас-Вегас, США. Стали известны после выпуска дебютного студийного альбома Night Visions в сентябре 2012 годa."))
        band.add(MusicBand(R.drawable.bony_m, "Boney M", "disco", 1975, "«Boney M» — диско-группа, созданная в 1975 году в ФРГ известным западногерманским музыкальным продюсером Фрэнком Фарианом. Все привлечённые к проекту исполнители родились за пределами Германии, на Карибских островах, перебравшись в Западную Европу в подростковом возрасте."))

        //СОздание объекта
        val myAdapter = Adapter(this, band)
        list.adapter = myAdapter // Передаємо його до віджету списку

        // Создание кнопки
        back.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        }
    }

