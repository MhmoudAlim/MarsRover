package mahmoud.alim.marsrover.domain.model


/**
 * @author Mahmoud Alim on 17/12/2022.
 */

sealed class RoverStatus(val value: String) {
    object Active : RoverStatus(ACTIVE)
    object Inactive : RoverStatus(INACTIVE)

    companion object {
        fun fromString(name: String): RoverStatus {
            return when (name) {
                ACTIVE -> Active
                else -> Inactive
            }
        }

        private const val ACTIVE = "active"
        private const val INACTIVE = "inactive"
    }
}


