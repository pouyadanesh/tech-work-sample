package tech.work.sample.domain.entity

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("page") val page: Int=1,
    @SerializedName("results") val movies: List<Movie> = listOf(),
    @SerializedName("total_pages") val totalPages: Int = 1,
    @SerializedName("total_results") val totalResults: Int = 0,
)