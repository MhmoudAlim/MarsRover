package mahmoud.alim.marsrover.data.remote.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import mahmoud.alim.marsrover.BuildConfig
import mahmoud.alim.marsrover.data.remote.api.RoversApi
import mahmoud.alim.marsrover.domain.mapper.toRoverPhoto
import mahmoud.alim.marsrover.domain.model.RoverPhoto
import retrofit2.HttpException
import java.io.IOException

/**
 * @author Mahmoud Alim on 16/12/2022.
 */
class PhotosDataSrc(
    private val api: RoversApi
) : PagingSource<Int, RoverPhoto>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RoverPhoto> {
        val position = params.key ?: 1
        return try {
            val response = api.getAllPhotos(
                sol = position,
                key = BuildConfig.API_KEY
            )
            val photos = response.photos.map { it.toRoverPhoto() }
            LoadResult.Page(
                data = photos,
                prevKey = if (position == 1) null else position,
                nextKey = if (photos.isEmpty()) null else position + 1
            )
        } catch (e: IOException) {
            return LoadResult.Error(e)
        } catch (e: HttpException) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, RoverPhoto>): Int? {
        return 1
    }


}