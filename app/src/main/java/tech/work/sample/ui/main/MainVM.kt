package tech.work.sample.ui.main

import dagger.hilt.android.lifecycle.HiltViewModel
import tech.work.sample.domain.usecase.GetMoviesUseCase
import javax.inject.Inject

@HiltViewModel
class MainVM @Inject constructor(
    private val getMoviesUseCse: GetMoviesUseCase,
) : BaseViewModel<MainContract.SingleEvent, MainContract.ViewState, MainContract.ViewIntent>() {


    /**
     * Create initial State of Views
     */
    override fun createInitialState(): MainContract.ViewState {
        return MainContract.ViewState(
            MainContract.RandomNumberState.Idle,
            false,
            listOf()
        )
    }

    /**
     * Handle each event
     */
    override suspend fun handleEvent(event: MainContract.SingleEvent) {
        generateRandomNumber()
    }

    private suspend fun generateRandomNumber() {
        val movies = getMoviesUseCse.invoke(1, 50)
        setState { copy(randomNumberState = MainContract.RandomNumberState.Success(movieItems = movies)) }
    }

}