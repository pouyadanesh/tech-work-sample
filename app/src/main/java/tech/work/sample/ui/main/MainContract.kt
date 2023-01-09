package tech.work.sample.ui.main

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import tech.work.sample.domain.entity.Movie
import tech.work.sample.mvi.MviIntent
import tech.work.sample.mvi.MviSingleEvent
import tech.work.sample.mvi.MviViewState

class MainContract {

    @Immutable
    sealed interface ViewIntent : MviIntent {
        object onRandomNumberClicked : ViewIntent
    }

    @Immutable
    data class ViewState(
        val randomNumberState: RandomNumberState,
        val isLoading: Boolean,
        val movies : List<Movie>
    ) : MviViewState

    sealed class RandomNumberState {
        object Idle : RandomNumberState()
        object Loading : RandomNumberState()
        data class Success(val movieItems: List<Movie>) : RandomNumberState()
    }

    sealed class SingleEvent : MviSingleEvent {
        object ShowToast : SingleEvent()

    }

}