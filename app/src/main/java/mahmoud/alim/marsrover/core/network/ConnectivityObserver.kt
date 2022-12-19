package mahmoud.alim.marsrover.core.network

import kotlinx.coroutines.flow.Flow

/**
 * @author Mahmoud Alim on 19/12/2022.
 */
interface ConnectivityObserver {

    fun observe(): Flow<NetworkStatus>

    enum class NetworkStatus {
        Available,
        Idle,
        Lost;
    }
}