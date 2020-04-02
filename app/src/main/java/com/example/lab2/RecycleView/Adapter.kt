package com.example.lab2.RecycleView

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lab2.MusicBand
import com.example.lab2.R
import kotlinx.android.synthetic.main.card_item.view.*

class Adapter(private var list: MutableList<MusicBand>) : RecyclerView.Adapter<Adapter.PersonViewHolder>() {

    // Начало работы
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): PersonViewHolder {
        //Создание макета
        val v: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_item, viewGroup, false)
        return PersonViewHolder(v)
    }
//Количество данных
    override fun getItemCount() = list.size

    //Получение данных
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.name.text = list[position].name
        holder.state.text = "Стиль: " + list[position].state
        holder.year.text = "Год создания: " + list[position].year
        holder.about.text = "Информация о группе:" + list[position].about
        holder.image.setImageResource(list[position].avatarId)

        holder.constrain.setOnClickListener { // Перехід на інший Activity
            val intent = Intent(holder.constrain.context, OneMusicBand::class.java)

            //Получение ключа
            intent.putExtra("position", position)
            intent.putParcelableArrayListExtra("list", ArrayList(list))

            holder.constrain.context.startActivity(intent)
        }
    }

    // Использование паттерна, установка данных
    class PersonViewHolder(@NonNull itemView: View) : ViewHolder(itemView) {
        var image: ImageView = itemView.imageView
        var name: TextView = itemView.fio
        var state: TextView = itemView.state
        var year: TextView = itemView.year
        var about: TextView = itemView.textView
        var constrain: ConstraintLayout = itemView.constrain
    }
}
