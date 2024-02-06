package com.moviesearchapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.RecyclerView
import com.moviesearchapp.databinding.ActivityMainBinding
import com.moviesearchapp.network.MovieApiService
import com.moviesearchapp.network.MovieRepository
import com.moviesearchapp.viewModel.MovieViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var movieViewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        movieViewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        binding.viewModel = movieViewModel
        binding.lifecycleOwner = this

        val recyclerView : RecyclerView = findViewById(R.id.movieRecyclerView)
        recyclerView.adapter = MovieAdapter()
    }
}
