package tech.work.sample.data.remote

import tech.work.sample.data.model.ResponseModel
import retrofit2.Response
import retrofit2.http.GET
import tech.work.sample.domain.entity.Movie

interface RemoteApi {

    @GET("a/346388320")
    suspend fun getMovies(
    ): List<Movie>

}