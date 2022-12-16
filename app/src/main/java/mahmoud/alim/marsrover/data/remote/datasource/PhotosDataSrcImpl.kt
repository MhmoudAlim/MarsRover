package mahmoud.alim.marsrover.data.remote.datasource

import mahmoud.alim.marsrover.BuildConfig
import mahmoud.alim.marsrover.data.remote.api.RoversApi
import mahmoud.alim.marsrover.data.remote.dto.RoversResponse

/**
 * @author Mahmoud Alim on 16/12/2022.
 */
class PhotosDataSrcImpl(
    private val api: RoversApi
) : PhotosDataSrc {

    override suspend fun getAllPhotos(): RoversResponse {
        return api.getAllPhotos(
            sol = 1000,
            key = BuildConfig.API_KEY
        )
    }
}