package mahmoud.alim.marsrover.data.repo


import mahmoud.alim.marsrover.domain.model.RoverPhoto

/**
 * @author Mahmoud Alim on 16/12/2022.
 */
interface RoversPhotosRepo {

    suspend fun getPhotos(): Result<List<RoverPhoto>>
}