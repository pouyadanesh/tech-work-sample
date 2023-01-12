package tech.work.sample.domain.entity

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("adult") val adult: Boolean = false,
    @SerializedName("id") val id: Int = 0,
    @SerializedName("popularity") var popularity: Double = 0.0,
    @SerializedName("original_title") val originalTitle: String = "",
    @SerializedName("poster_path") val avatar: String = "",
    @SerializedName("overview") val overview: String = "",
    @SerializedName("release_date") val releaseDate: String = "",
    @SerializedName("title") val title: String = "",
    @SerializedName("video") val video: Boolean = false,
    @SerializedName("vote_average") val voteAverage: Double = 0.0,
    @SerializedName("vote_count") val voteCount: Int = 0
)
