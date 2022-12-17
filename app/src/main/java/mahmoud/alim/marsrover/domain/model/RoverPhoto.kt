package mahmoud.alim.marsrover.domain.model

/**
 * @author Mahmoud Alim on 17/12/2022.
 */

data class RoverPhoto(
    val id: Int,
    val imageSrc: String,
    val earthDate: String,
    val cameraName: String,
    val roverId: Int,
    val roverName: String,
    val roverStatus: RoverStatus,
    val roverLandingDate: String,
    val roverLaunchDate: String,
)