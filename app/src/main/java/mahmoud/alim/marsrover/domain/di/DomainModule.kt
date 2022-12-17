package mahmoud.alim.marsrover.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import mahmoud.alim.marsrover.data.repo.RoversPhotosRepo
import mahmoud.alim.marsrover.domain.usecase.GetAllRoverPhotos

/**
 * @author Mahmoud Alim on 17/12/2022.
 */

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    @ViewModelScoped
    fun provideGetAllRoverPhotosUseCase(
        repo: RoversPhotosRepo
    ): GetAllRoverPhotos {
        return GetAllRoverPhotos(repo = repo)
    }

}