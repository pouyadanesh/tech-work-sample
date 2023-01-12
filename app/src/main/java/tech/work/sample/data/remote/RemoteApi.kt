package tech.work.sample.data.remote

import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query
import tech.work.sample.domain.entity.MovieResponse

interface RemoteApi {

    @GET("/3/movie/top_rated")
    suspend fun getMovies(
        @Query("api_key") apiKey:String ,
        @Query("page") page:Int
    ): MovieResponse

    companion object {
        operator fun invoke(retrofit: Retrofit) = retrofit.create<RemoteApi>()
    }
}