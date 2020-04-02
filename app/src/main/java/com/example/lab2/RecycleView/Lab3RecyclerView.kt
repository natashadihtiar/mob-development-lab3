package com.example.lab2.RecycleView

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2.MainActivity
import com.example.lab2.MusicBand
import com.example.lab2.R
import kotlinx.android.synthetic.main.activity_lab3_recycler_view.back


class Lab3RecyclerView : Activity() {

    //Изменение адаптера и менеджера
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab3_recycler_view)
        title = "Lab3 RecyclerView"

        val band: MutableList<MusicBand> = ArrayList() // Створення і заповнення об'єктів классу People
        band.add(MusicBand(R.drawable.imagine_dragons, "Imagine Dragons", "rock", 2012, "«Imagine Dragons» — американская инди-рок-группа, образованная в 2008 году в городе Лас-Вегас, США. Стали известны после выпуска дебютного студийного альбома Night Visions в сентябре 2012 годa."))
        band.add(MusicBand(R.drawable.bony_m, "Boney M", "disco", 1975, "«Boney M» — диско-группа, созданная в 1975 году в ФРГ известным западногерманским музыкальным продюсером Фрэнком Фарианом. Все привлечённые к проекту исполнители родились за пределами Германии, на Карибских островах, перебравшись в Западную Европу в подростковом возрасте."))

        // Позиционирование всех элементов
        viewManager = LinearLayoutManager(this)
        //Адаптер
        viewAdapter = Adapter(band)
        // ССылка на объект
        recyclerView = findViewById<RecyclerView>(R.id.recyclerview).apply {
            setHasFixedSize(true) // Розмір RecyclerView не буде змінюватись
            layoutManager = viewManager
            adapter = viewAdapter
        }

        // Создание кнопки
        back.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}
