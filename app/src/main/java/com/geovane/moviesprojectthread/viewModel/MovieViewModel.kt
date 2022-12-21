package com.geovane.moviesprojectthread.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.geovane.moviesprojectthread.model.Movie
import com.geovane.moviesprojectthread.resources.MovieRepositoryMock

class MovieViewModel(private val repositoryMock: MovieRepositoryMock) : ViewModel() {

    var movieLiveData = MutableLiveData<List<Movie>>()

    fun getMovie() {
        repositoryMock.getMovie { movies ->
            movieLiveData.postValue(movies)
        }
    }

    class MovieViewModelFactory(
        private val repositoryMock: MovieRepositoryMock
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MovieViewModel(repositoryMock) as T
        }

    }
}