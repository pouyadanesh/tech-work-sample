package tech.work.sample.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import tech.work.sample.ui.main.MainContract
import tech.work.sample.ui.main.MainListScreen
import tech.work.sample.ui.main.MainVM

@Composable
fun MainListScreenDestination(navController: NavController) {
    val viewModel: MainVM = hiltViewModel()
    MainListScreen(
        state = viewModel.currentState,
        effectFlow = viewModel.effect,
        onEventSent = { event ->  viewModel.setEvent(event) },
        onNavigationRequested = { navigationEffect ->
            if (navigationEffect is MainContract.ViewIntent.Navigation.ToMovieDetail) {
                navController.navigateToMovieDetail(navigationEffect.movieId)
            }
        }
    )
}