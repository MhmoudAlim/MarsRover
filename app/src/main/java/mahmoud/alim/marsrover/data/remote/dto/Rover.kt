package mahmoud.alim.marsrover.data.remote.dto


import com.squareup.moshi.Json

data class Rover(
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "landing_date")
    val landingDate: String,
    @field:Json(name = "launch_date")
    val launchDate: String,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "status")
    val status: String
)