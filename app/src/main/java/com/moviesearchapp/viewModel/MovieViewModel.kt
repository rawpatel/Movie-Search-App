package com.moviesearchapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moviesearchapp.network.Movie
import com.moviesearchapp.network.MovieRepository
import kotlinx.coroutines.launch

class MovieViewModel(private val repository: MovieRepository) : ViewModel() {
    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>>
        get() = _movies

    fun searchMovie(query: String) {
        viewModelScope.launch {
            try {
                _movies.value = repository.searchMovie(query)
            } catch (e: Exception) {
                // Handle exception
            }
        }
    }
}
