package mahmoud.alim.marsrover.data.remote.dto


import com.squareup.moshi.Json

data class Photo(
    @Json(name = "camera")
    val camera: Camera,
    @Json(name = "earth_date")
    val earthDate: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "img_src")
    val imgSrc: String,
    @Json(name = "rover")
    val rover: Rover,
    @Json(name = "sol")
    val sol: Int
)