package tech.work.sample.data

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import tech.work.sample.BuildConfig
import tech.work.sample.data.remote.RemoteApi
import tech.work.sample.domain.entity.MovieResponse
import tech.work.sample.domain.providers_schedulers.CoroutinesDispatchersProvider
import tech.work.sample.domain.repository.MovieRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepositoryImpl @Inject constructor(
    private val apiService: RemoteApi,
    private val dispatcher: CoroutinesDispatchersProvider,
) : MovieRepository {

    override suspend fun getPosts(start: Int, limit: Int): Result<MovieResponse> =
        makeApiCall(dispatcher.io) {
            apiService.getMovies(BuildConfig.API_KEY, start)
        }

}

suspend fun <T> makeApiCall(
    dispatcher: CoroutineDispatcher,
    call: suspend () -> T
): Result<T> = runCatching {
    withContext(dispatcher) {
        call.invoke()
    }
}