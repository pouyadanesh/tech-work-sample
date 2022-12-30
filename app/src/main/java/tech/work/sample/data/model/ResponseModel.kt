package tech.work.sample.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ResponseModel(
    @SerializedName("images") val images: List<ImagesInfoModel>
): Serializable
