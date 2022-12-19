package mahmoud.alim.marsrover.presentation.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * @author Mahmoud Alim on 19/12/2022.
 */

@Parcelize
data class RoverPhotoDetails(
    val imageSrc: String,
    val roverName: String,
    val launchDate: String,
    val landingDate: String,
    val cameraName: String,
    val status: String,
    val earthDate: String
) : Parcelable