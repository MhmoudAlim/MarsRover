/**
 * @author Mahmoud Alim on 16/12/2022.
 */
object AndroidX {
    private const val coreKtxVersion = "1.7.0"
    const val coreKtx = "androidx.core:core-ktx:$coreKtxVersion"

    private const val appCompatVersion = "1.5.1"
    const val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"

    private const val constraintVersion = "2.1.4"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:$constraintVersion"

    private const val pagingVersion = "3.1.1"
    const val paging = "androidx.paging:paging-runtime:$pagingVersion"

    private const val lifecycleVersion = "2.4.1"
    const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion"

    private const val splashScreenVersion = "1.0.0"
    const val splashScreen = "androidx.core:core-splashscreen:$splashScreenVersion"

    private const val navVersion = "2.5.3"
    const val fragmentNavigation =  "androidx.navigation:navigation-fragment-ktx:$navVersion"
    const val uiNavigation =  "androidx.navigation:navigation-ui-ktx:$navVersion"
    const val safeArgs =  "androidx.navigation:navigation-safe-args-gradle-plugin:$navVersion"

    private const val hiltNavVersion = "1.0.0"
    const val hiltNavigation =  "androidx.hilt:hilt-navigation-fragment:$hiltNavVersion"
    const val hiltCompiler = "androidx.hilt:hilt-compiler:$hiltNavVersion"

}