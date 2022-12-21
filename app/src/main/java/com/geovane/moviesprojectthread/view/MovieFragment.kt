package com.geovane.moviesprojectthread.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.geovane.moviesprojectthread.R
import com.geovane.moviesprojectthread.resources.MovieRepositoryMock
import com.geovane.moviesprojectthread.viewModel.MovieViewModel
import kotlinx.android.synthetic.main.fragment_movie.*


class MovieFragment : Fragment(R.layout.fragment_movie) {

    private lateinit var viewModel: MovieViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(
            this,
            MovieViewModel.MovieViewModelFactory(
                MovieRepositoryMock()
            )).get(MovieViewModel::class.java)

        viewModel.movieLiveData.observe(viewLifecycleOwner, Observer { movies ->
            TextViewFirstMovie.text = movies[0].title
            TextViewSecondMovie.text = movies[1].title
            TextViewThirdMovie.text = movies[2].title
            TextViewFourMovie.text = movies[3].title
        })

        viewModel.getMovie()
    }
}