package tech.work.sample.data

import kotlinx.coroutines.withContext
import tech.work.sample.data.remote.RemoteApi
import tech.work.sample.domain.entity.Movie
import tech.work.sample.domain.providers_schedulers.CoroutinesDispatchersProvider
import tech.work.sample.domain.repository.MovieRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepositoryImpl @Inject constructor(
    private val apiService: RemoteApi,
    private val dispatchersProvider: CoroutinesDispatchersProvider
) : MovieRepository {
    override suspend fun getPosts(start: Int, limit: Int): List<Movie> {
        return withContext(dispatchersProvider.io) {
            apiService.getMovies()
        }
    }
}