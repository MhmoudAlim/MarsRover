package mahmoud.alim.marsrover.domain.mapper

import mahmoud.alim.marsrover.data.remote.dto.Photo
import mahmoud.alim.marsrover.domain.model.RoverPhoto
import mahmoud.alim.marsrover.domain.model.RoverStatus

/**
 * @author Mahmoud Alim on 17/12/2022.
 */

fun Photo.toRoverPhoto(): RoverPhoto {
    return RoverPhoto(
        id = id,
        imageSrc = imgSrc,
        earthDate = earthDate,
        cameraName = camera.fullName,
        roverId = rover.id,
        roverName = rover.name,
        roverLandingDate = rover.landingDate,
        roverLaunchDate = rover.launchDate,
        roverStatus = RoverStatus.fromString(rover.status)
    )
}