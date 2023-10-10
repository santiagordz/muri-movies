package com.murimovies.framework.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.murimovies.databinding.ItemMovieBinding
import com.murimovies.domain.model.Movie
import com.murimovies.framework.adapters.viewholders.MovieListViewHolder

class MovieListAdapter: RecyclerView.Adapter<MovieListViewHolder>() {
    var data:ArrayList<Movie> = ArrayList()
    lateinit var context: Context

    fun MovieListAdapter(basicData : ArrayList<Movie>, context:Context){
        this.data = basicData
        this.context = context
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item,context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MovieListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}