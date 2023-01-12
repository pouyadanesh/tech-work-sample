package tech.work.sample.domain.usecase

import tech.work.sample.domain.entity.MovieResponse
import tech.work.sample.domain.repository.MovieRepository
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(start: Int, limit: Int): Result<MovieResponse> {
        return movieRepository.getPosts(start = start, limit = limit)
    }
}