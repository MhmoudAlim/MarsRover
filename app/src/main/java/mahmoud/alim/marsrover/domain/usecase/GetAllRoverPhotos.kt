package mahmoud.alim.marsrover.domain.usecase

import mahmoud.alim.marsrover.data.repo.RoversPhotosRepo
import mahmoud.alim.marsrover.domain.model.RoverPhoto

/**
 * @author Mahmoud Alim on 17/12/2022.
 */
class GetAllRoverPhotos(private val repo: RoversPhotosRepo) {

    suspend operator fun invoke() : Result<List<RoverPhoto>>{
        return repo.getPhotos()
    }
}