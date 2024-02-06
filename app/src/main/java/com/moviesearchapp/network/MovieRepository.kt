package com.moviesearchapp.network

class MovieRepository(private val apiService: MovieApiService) {
    suspend fun searchMovie(query: String): List<Movie> {
        return apiService.searchMovie(
            query,
            "arGiw6O4PtmshRnu6VGgrcJiO3DJp1cuMVojsnEABg5WRSaZVu",
            "imdb8.p.rapidapi.com"
        ).await()
    }
}
