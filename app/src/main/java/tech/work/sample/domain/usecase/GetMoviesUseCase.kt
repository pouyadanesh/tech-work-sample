package tech.work.sample.domain.usecase

import tech.work.sample.domain.entity.Movie
import tech.work.sample.domain.repository.MovieRepository
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val postRepository: MovieRepository
) {
    suspend operator fun invoke(start: Int, limit: Int): List<Movie> {
        return postRepository.getPosts(start = start, limit = limit)
    }
}