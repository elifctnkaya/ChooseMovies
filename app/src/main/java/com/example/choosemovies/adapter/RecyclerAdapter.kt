package com.example.choosemovies.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.example.choosemovies.Movies
import com.example.choosemovies.R
import com.example.choosemovies.Results

class RecyclerAdapter(private val moviesList: List<Results>, val onClick : (Results) -> Unit): RecyclerView.Adapter<RecyclerAdapter.MoviesViewHolder>() {

    class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.findViewById(R.id.image_view)


        fun bind(movies: Results, onClick: (Results) -> Unit){
            Glide.with(itemView)
                .load("https://image.tmdb.org/t/p/w342${movies.poster_path}")
                .transform(CenterCrop())
                .into(imageView)

            itemView.setOnClickListener {
                onClick(movies)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : MoviesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.popular_item_layout,parent,false)
        return MoviesViewHolder(itemView)

    }


    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val i = moviesList[position]
        holder.bind(i,onClick)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

}