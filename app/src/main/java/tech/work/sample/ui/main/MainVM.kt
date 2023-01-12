package tech.work.sample.ui.main

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import tech.work.sample.domain.usecase.GetMoviesUseCase
import javax.inject.Inject

@HiltViewModel
class MainVM @Inject constructor(
    private val getMoviesUseCse: GetMoviesUseCase,
) : BaseViewModel<MainContract.SingleEvent, MainContract.ViewState, MainContract.ViewIntent>() {

    init {
        getMovies()
    }

    /**
     * Create initial State of Views
     */
    override fun createInitialState(): MainContract.ViewState {
        return MainContract.ViewState(
            isError = false,
            isLoading = true,
            movies = listOf()
        )
    }

    /**
     * Handle each event
     */
    override suspend fun handleEvent(event: MainContract.SingleEvent) {
        when (event) {
            is MainContract.SingleEvent.Retry -> getMovies()
            is MainContract.SingleEvent.MovieSelection -> setEffect {
                MainContract.ViewIntent.Navigation.ToMovieDetail(
                    event.movie.id
                )
            }
        }
    }

    fun getMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            setState { copy(isLoading = true, isError = false) }

            getMoviesUseCse.invoke(1, 50)
                .onSuccess { result ->
                    setState { copy(movies = result.movies, isLoading = false, isError = false) }
                    setEffect { MainContract.ViewIntent.DataWasLoaded }
                }
                .onFailure {
                    setState { copy(isError = true, isLoading = false) }
                }
        }
    }

}