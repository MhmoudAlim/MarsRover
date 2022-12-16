package mahmoud.alim.marsrover.data.remote.api

import mahmoud.alim.marsrover.data.remote.dto.RoversResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Mahmoud Alim on 16/12/2022.
 */
interface RoversApi {

    @GET("v1/rovers/curiosity/photos")
    suspend fun getAllPhotos(
        @Query("sol") sol: Int,
        @Query("api_key") key: String,
    ): RoversResponse


    companion object {
        const val BASE_URL = "https://api.nasa.gov/mars-photos/api/"
    }
}