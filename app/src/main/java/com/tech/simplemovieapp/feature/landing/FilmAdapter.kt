package com.tech.simplemovieapp.feature.landing

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.tech.simplemovieapp.R
import com.tech.simplemovieapp.data.model.Film
import com.tech.simplemovieapp.databinding.ItemFilmBinding

class FilmAdapter : RecyclerView.Adapter<FilmViewHolder>() {

    private val items = ArrayList<Film>()

    fun setItems(items: ArrayList<Film>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val binding = ItemFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilmViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

}

class FilmViewHolder(
    private val itemBinding: ItemFilmBinding
) : RecyclerView.ViewHolder(itemBinding.root) {

    private lateinit var film: Film

    fun bind(item: Film) {
        this.film = item

        itemBinding.iconTypeFilm.apply {
            when (film.type) {
                "MOVIE" -> {
                    setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_baseline_local_movies_24
                        )
                    )
                }
                "SERIES" -> {
                    setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_baseline_tv_24
                        )
                    )
                }
            }
        }

        itemBinding.tvNameFilm.text = film.name
    }

}