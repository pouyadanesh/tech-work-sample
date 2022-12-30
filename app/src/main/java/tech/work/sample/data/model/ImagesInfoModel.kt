package tech.work.sample.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ImagesInfoModel(
    @SerializedName("uri") var imageUrl: String
): Serializable

fun ImagesInfoModel.convertToThumb(): String {

    return "$imageUrl?rule=mo-640.jpg"
}

fun ImagesInfoModel.convertToBigImage(): String {

    return "$imageUrl?rule=mo-1600.jpg"
}
