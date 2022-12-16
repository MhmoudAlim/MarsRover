package mahmoud.alim.marsrover.data.remote.datasource

import mahmoud.alim.marsrover.data.remote.dto.RoversResponse

/**
 * @author Mahmoud Alim on 16/12/2022.
 */
interface PhotosDataSrc {

    suspend fun getAllPhotos(): RoversResponse

}