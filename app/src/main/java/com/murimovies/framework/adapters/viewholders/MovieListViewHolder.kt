package com.murimovies.framework.adapters.viewholders

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.murimovies.databinding.ItemMovieBinding
import com.murimovies.domain.model.Movie

class MovieListViewHolder(private val binding: ItemMovieBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Movie, context: Context) {
        binding.title.text = item.title
    }
}