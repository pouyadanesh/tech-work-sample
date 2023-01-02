package tech.work.sample.data.remote

import tech.work.sample.data.model.ResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import tech.work.sample.domain.entity.Movie

interface RemoteApi {

    @GET("/movie/top_rated")
    suspend fun getMovies(
        @Query("api_key") apiKey:String ,
        @Query("page") page:Int
    ): List<Movie>

}