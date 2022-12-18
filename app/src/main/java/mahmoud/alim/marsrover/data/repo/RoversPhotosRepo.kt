package mahmoud.alim.marsrover.data.repo


import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import mahmoud.alim.marsrover.domain.model.RoverPhoto

/**
 * @author Mahmoud Alim on 16/12/2022.
 */
interface RoversPhotosRepo {

     fun getPhotos(): Flow<PagingData<RoverPhoto>>
}