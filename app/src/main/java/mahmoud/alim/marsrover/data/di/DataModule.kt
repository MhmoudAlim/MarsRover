package mahmoud.alim.marsrover.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mahmoud.alim.marsrover.data.remote.api.RoversApi
import mahmoud.alim.marsrover.data.remote.datasource.PhotosDataSrc
import mahmoud.alim.marsrover.data.remote.datasource.PhotosDataSrcImpl
import mahmoud.alim.marsrover.data.repo.RoversPhotosRepo
import mahmoud.alim.marsrover.data.repo.RoversPhotosRepoImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * @author Mahmoud Alim on 16/12/2022.
 */

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideOkHttpClient() = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        })
        .connectTimeout(6, TimeUnit.SECONDS)
        .readTimeout(6, TimeUnit.SECONDS)
        .build()


    @Provides
    @Singleton
    fun provideFootballApi(client: OkHttpClient): RoversApi {
        return Retrofit.Builder().apply {
            baseUrl(RoversApi.BASE_URL)
            addConverterFactory(MoshiConverterFactory.create())
            client(client)
        }
            .build()
            .create()
    }


    @Provides
    @Singleton
    fun provideRemotePhotosDataRrc(api: RoversApi): PhotosDataSrc {
        return PhotosDataSrcImpl(api)
    }


    @Provides
    @Singleton
    fun provideRoversPhotosRepo(
        remoteDataSrc: PhotosDataSrc,
    ): RoversPhotosRepo {
        return RoversPhotosRepoImpl(remote = remoteDataSrc)
    }


}