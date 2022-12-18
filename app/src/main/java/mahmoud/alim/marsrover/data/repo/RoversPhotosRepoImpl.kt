package mahmoud.alim.marsrover.data.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import mahmoud.alim.marsrover.data.remote.datasource.PhotosDataSrc
import mahmoud.alim.marsrover.domain.model.RoverPhoto

/**
 * @author Mahmoud Alim on 16/12/2022.
 */
class RoversPhotosRepoImpl(
    private val remote: PhotosDataSrc
) : RoversPhotosRepo {

    override fun getPhotos(): Flow<PagingData<RoverPhoto>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = true
            ),
            pagingSourceFactory = { remote }
        ).flow
    }
}