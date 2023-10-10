package com.murimovies.framework.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.murimovies.R
import com.murimovies.databinding.FragmentMovieListBinding
import com.murimovies.domain.model.Movie
import com.murimovies.framework.adapters.MovieListAdapter
import com.murimovies.framework.viewmodel.MovieListViewModel

class MovieListFragment: Fragment(){
    private var _binding : FragmentMovieListBinding? = null

    private val binding get() = _binding!!
    private lateinit var viewModel: MovieListViewModel
    private lateinit var recyclerView: RecyclerView
    private val adapter : MovieListAdapter = MovieListAdapter()
    private lateinit var data:ArrayList<Movie>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View {
        viewModel = ViewModelProvider(this)[MovieListViewModel::class.java]

        _binding = FragmentMovieListBinding.inflate(inflater, container, false)
        val root: View = binding.root

        data = ArrayList()

        initializeComponents(root)
        initializeObservers()
        viewModel.getMovieList()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initializeComponents(root: View){
        recyclerView = root.findViewById(R.id.RVMovies)
    }

    private fun initializeObservers() {
        viewModel.movieListLiveData.observe(viewLifecycleOwner) { movieResponse ->
            setUpRecyclerView(movieResponse.results)
        }
    }

    private fun setUpRecyclerView(dataForList:ArrayList<Movie>){
        recyclerView.setHasFixedSize(true)
        val gridLayoutManager = GridLayoutManager(requireContext(), 3, GridLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = gridLayoutManager
        adapter.MovieListAdapter(dataForList,requireContext())
        recyclerView.adapter = adapter
    }

}