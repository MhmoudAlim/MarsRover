package mahmoud.alim.marsrover.data.remote.dto


import com.squareup.moshi.Json

data class RoversResponse(
    @Json(name = "photos")
    val photos: List<Photo>
)