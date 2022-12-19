package mahmoud.alim.marsrover.core.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mahmoud.alim.marsrover.core.network.ConnectivityObserver
import mahmoud.alim.marsrover.core.network.NetworkConnectivityObserver
import javax.inject.Singleton

/**
 * @author Mahmoud Alim on 19/12/2022.
 */

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {

    @Singleton
    @Provides
    fun provideNetworkConnectivityObserver(app: Application): ConnectivityObserver {
        return NetworkConnectivityObserver(app)
    }
}