package tech.work.sample.domain.repository

import tech.work.sample.domain.entity.Movie

interface MovieRepository {
    suspend fun getPosts(
        start: Int,
        limit: Int
    ): List<Movie>
}