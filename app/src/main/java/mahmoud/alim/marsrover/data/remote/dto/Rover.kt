package mahmoud.alim.marsrover.data.remote.dto


import com.squareup.moshi.Json

data class Rover(
    @Json(name = "id")
    val id: Int,
    @Json(name = "landing_date")
    val landingDate: String,
    @Json(name = "launch_date")
    val launchDate: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "status")
    val status: String
)