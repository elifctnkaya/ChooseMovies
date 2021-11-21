package com.example.choosemovies.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.choosemovies.R
import com.example.choosemovies.adapter.RecyclerAdapter
import com.example.choosemovies.RetrofitProvider

class MoviesFragment : Fragment() {

    private lateinit var recyclerViewPop : RecyclerView
    private lateinit var recyclerViewTop : RecyclerView
    private lateinit var recyclerViewNow : RecyclerView
    private lateinit var recyclerViewUpComing : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewPop = view.findViewById(R.id.recyclerViewPop)
        recyclerViewTop = view.findViewById(R.id.recyclerViewTop)
        recyclerViewNow = view.findViewById(R.id.recyclerViewNow)
        recyclerViewUpComing = view.findViewById(R.id.recyclerViewUpComing)

        lifecycleScope.launchWhenCreated {
            val responsePop = RetrofitProvider.moviesApi.getMoviesPop("YOUR API KEY",  "1")
            recyclerViewPop.adapter = RecyclerAdapter(responsePop.results.orEmpty().toMutableList()){
                val action = MoviesFragmentDirections.actionMoviesFragmentToMoviesDetailFragment(it)
                findNavController().navigate(action)
            }
            recyclerViewPop.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)

            val responseTop = RetrofitProvider.moviesApi.getTopRated("YOUR API KEY", "1")
            recyclerViewTop.adapter = RecyclerAdapter(responseTop.results.orEmpty().toMutableList()){
                val action = MoviesFragmentDirections.actionMoviesFragmentToMoviesDetailFragment(it)
                findNavController().navigate(action)
            }
            recyclerViewTop.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)

            val responseNow = RetrofitProvider.moviesApi.getNowPlaying("YOUR API KEY", "1")
            recyclerViewNow.adapter = RecyclerAdapter(responseNow.results.orEmpty().toMutableList()){
                val action = MoviesFragmentDirections.actionMoviesFragmentToMoviesDetailFragment(it)
                findNavController().navigate(action)
            }
            recyclerViewNow.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)

            val responseUpComing = RetrofitProvider.moviesApi.getUpComing("YOUR API KEY", "1")
            recyclerViewUpComing.adapter = RecyclerAdapter(responseUpComing.results.orEmpty().toMutableList()){
                val action = MoviesFragmentDirections.actionMoviesFragmentToMoviesDetailFragment(it)
                findNavController().navigate(action)
            }
            recyclerViewUpComing.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL,false)

        }
    }
}