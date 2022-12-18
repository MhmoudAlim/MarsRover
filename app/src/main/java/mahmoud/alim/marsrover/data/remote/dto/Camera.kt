package mahmoud.alim.marsrover.data.remote.dto


import com.squareup.moshi.Json

data class Camera(
    @field:Json(name = "full_name")
    val fullName: String,
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "rover_id")
    val roverId: Int
)