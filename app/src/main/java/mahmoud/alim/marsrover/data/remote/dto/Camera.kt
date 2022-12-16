package mahmoud.alim.marsrover.data.remote.dto


import com.squareup.moshi.Json

data class Camera(
    @Json(name = "full_name")
    val fullName: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "rover_id")
    val roverId: Int
)