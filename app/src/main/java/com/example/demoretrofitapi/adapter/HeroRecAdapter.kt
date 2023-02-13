package com.example.demoretrofitapi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.demoretrofitapi.R
import com.example.demoretrofitapi.adapter.HeroRecAdapter.*
import com.example.demoretrofitapi.model.Superhero
import com.squareup.picasso.Picasso

class HeroRecAdapter(private val context: Context) :
    RecyclerView.Adapter<HeroRecAdapter.ViewHolder>() {

    private val heroList = mutableListOf<Superhero>()

    fun submitList(list: List<Superhero>) {
        heroList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.superhero_card, parent, false)
        return ViewHolder(view)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val heroImage = itemView.findViewById<ImageView>(R.id.tv_hero_img)
        private val heroName = itemView.findViewById<AppCompatTextView>(R.id.tv_hero_name)
        private val heroGender = itemView.findViewById<AppCompatTextView>(R.id.tv_hero_gender)
        private val heroWeight = itemView.findViewById<AppCompatTextView>(R.id.tv_hero_weight)
        private val heroPublisher = itemView.findViewById<AppCompatTextView>(R.id.tv_hero_publisher)

        fun bind(hero: Superhero) {
            Picasso.get().load(hero.images.lg).into(heroImage)
            heroName.text = hero.name
            heroGender.text = hero.appearance.gender
            heroWeight.text = hero.appearance.weight.toString()
            heroPublisher.text = hero.biography.publisher
        }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hero = heroList[position]
        holder.bind(hero)
    }

    override fun getItemCount(): Int = heroList.size

}