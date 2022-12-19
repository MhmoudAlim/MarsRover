package mahmoud.alim.marsrover.presentation.ui.screens.photos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import mahmoud.alim.marsrover.domain.mapper.toRoverPhotoDetails
import mahmoud.alim.marsrover.domain.model.RoverPhoto
import mahmoud.alim.marsrover.domain.usecase.GetAllRoverPhotos
import mahmoud.alim.marsrover.presentation.ui.model.RoverPhotoDetails
import javax.inject.Inject

/**
 * @author Mahmoud Alim on 19/12/2022.
 */

@HiltViewModel
class PhotosViewModel @Inject constructor(
    private val getAllRoverPhotos: GetAllRoverPhotos,
) : ViewModel() {

    val photos
        get() = getAllRoverPhotos().cachedIn(viewModelScope)


    fun getPhotoDetails(photo: RoverPhoto): RoverPhotoDetails {
        with(photo) {
            return this.toRoverPhotoDetails()
        }
    }
}
