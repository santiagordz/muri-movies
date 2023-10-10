package com.murimovies.framework.views

import androidx.fragment.app.Fragment
import com.murimovies.databinding.FragmentMovieListBinding
import com.murimovies.framework.viewmodel.MovieListViewModel

class MovieListFragment: Fragment(){
    private var _binding : FragmentMovieListBinding? = null
    private lateinit var viewmodel: MovieListViewModel

}