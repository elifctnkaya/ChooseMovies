package com.example.choosemovies.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import coil.load
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.example.choosemovies.R

class MoviesDetailFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies_detail, container, false)
    }

    private val args by navArgs<MoviesDetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val image_detail = view.findViewById<ImageView>(R.id.image_detail)
        val movie_name = view.findViewById<TextView>(R.id.movie_name)
        val point = view.findViewById<TextView>(R.id.point)
        val date = view.findViewById<TextView>(R.id.date)
        val overview = view.findViewById<TextView>(R.id.overview)

        Glide.with(view)
            .load("https://image.tmdb.org/t/p/w342${args.movie.poster_path}")
            .transform(CenterCrop())
            .into(image_detail)
        movie_name.text = args.movie.title
        point.text = "IMDB: ${args.movie.vote_average.toString()}"
        date.text = args.movie.release_date
        overview.text = args.movie.overview
    }
}