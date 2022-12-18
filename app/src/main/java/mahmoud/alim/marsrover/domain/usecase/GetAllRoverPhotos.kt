package mahmoud.alim.marsrover.domain.usecase

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import mahmoud.alim.marsrover.data.repo.RoversPhotosRepo
import mahmoud.alim.marsrover.domain.model.RoverPhoto

/**
 * @author Mahmoud Alim on 17/12/2022.
 */
class GetAllRoverPhotos(private val repo: RoversPhotosRepo) {

    operator fun invoke(): Flow<PagingData<RoverPhoto>> {
        return repo.getPhotos()
    }
}