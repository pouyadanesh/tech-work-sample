package tech.work.sample.ui.main

import tech.work.sample.domain.entity.Movie
import tech.work.sample.mvi.MviIntent
import tech.work.sample.mvi.MviSingleEvent
import tech.work.sample.mvi.MviViewState

class MainContract {

    sealed class ViewIntent : MviIntent {
        object DataWasLoaded : ViewIntent()

        sealed class Navigation : ViewIntent() {
            data class ToMovieDetail(val movieId: Int): Navigation()
        }
    }

    data class ViewState(
        val isError: Boolean,
        val isLoading: Boolean,
        val movies : List<Movie>
    ) : MviViewState

    sealed class RandomNumberState {
        object Idle : RandomNumberState()
        object Loading : RandomNumberState()
        data class Success(val movieItems: List<Movie>) : RandomNumberState()
    }

    sealed class SingleEvent : MviSingleEvent {
        object Retry : SingleEvent()
        data class MovieSelection(val movie: Movie) : SingleEvent()

    }

}