package tech.work.sample.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavType
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import tech.work.sample.ui.navigation.Navigation.Args.MOVIE_ID

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Navigation.Routes.MOVIES
    ) {
        composable(
            route = Navigation.Routes.MOVIES
        ) {
            MainListScreenDestination(navController)
        }

        composable(
            route = Navigation.Routes.MOVIE_DETAIL,
            arguments = listOf(navArgument(name = MOVIE_ID) {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val movieId = requireNotNull(backStackEntry.arguments?.getInt(MOVIE_ID)) { "Movie id is required as an argument" }
            MovieDetailScreenDestination(
                MovieId = movieId,
                navController = navController
            )
        }
    }
}

object Navigation {

    object Args {
        const val MOVIE_ID = "movie_id"
    }

    object Routes {
        const val MOVIES = "movies"
        const val MOVIE_DETAIL = "$MOVIES/{$MOVIE_ID}"
    }

}

fun NavController.navigateToMovieDetail(movieId: Int) {
    navigate(route = "${Navigation.Routes.MOVIES}/$movieId")
}