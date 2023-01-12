package tech.work.sample.domain.repository

import tech.work.sample.domain.entity.MovieResponse

interface MovieRepository {
    suspend fun getPosts(
        start: Int,
        limit: Int
    ): Result<MovieResponse>
}