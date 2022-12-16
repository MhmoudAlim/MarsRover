package mahmoud.alim.marsrover.data.repo

import mahmoud.alim.marsrover.data.remote.datasource.PhotosDataSrc
import mahmoud.alim.marsrover.data.remote.dto.Photo

/**
 * @author Mahmoud Alim on 16/12/2022.
 */
class RoversPhotosRepoImpl(
    private val remote: PhotosDataSrc
) : RoversPhotosRepo {

    override suspend fun getPhotos(): Result<List<Photo>> {
        return try{
            val roversDto = remote.getAllPhotos()
            Result.success(roversDto.photos)
        }catch (e:Exception){
            e.printStackTrace()
            Result.failure(e)
        }
    }
}