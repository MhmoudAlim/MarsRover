package mahmoud.alim.marsrover.data.remote.dto


import com.squareup.moshi.Json

data class Photo(
    @field:Json(name = "camera")
    val camera: Camera,
    @field:Json(name = "earth_date")
    val earthDate: String,
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "img_src")
    val imgSrc: String,
    @field:Json(name = "rover")
    val rover: Rover,
    @field:Json(name = "sol")
    val sol: Int
)