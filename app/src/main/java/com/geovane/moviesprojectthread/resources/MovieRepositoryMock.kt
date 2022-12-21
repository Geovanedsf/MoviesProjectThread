package com.geovane.moviesprojectthread.resources

import com.geovane.moviesprojectthread.model.Movie
import javax.security.auth.callback.Callback

class MovieRepositoryMock {

    fun getMovie(callback: (movies: List<Movie>) -> Unit) {
        Thread(Runnable {
            Thread.sleep(1000)
            callback.invoke(
                listOf(
                    Movie(id = 0, title = "Poderoso Chefão"),
                    Movie(id = 1, title = "O Homem que Copiava"),
                    Movie(id = 2, title = "Pinóquio"),
                    Movie(id = 3, title = "Mortal Kombat")
                )
            )

        }).start()
    }
}