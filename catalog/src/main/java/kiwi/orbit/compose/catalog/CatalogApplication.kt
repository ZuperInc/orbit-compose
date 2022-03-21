package kiwi.orbit.compose.catalog

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.FadeTransition
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kiwi.orbit.compose.catalog.screens.MainScreen
import kotlinx.coroutines.flow.MutableStateFlow

val LightTheme = MutableStateFlow(true)

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CatalogApplication() {
    ProvideWindowInsets {
        val isLightTheme by LightTheme.collectAsState()
        val systemUiController = rememberSystemUiController()

        SideEffect {
            systemUiController.setSystemBarsColor(
                color = Color.Transparent,
                darkIcons = isLightTheme,
            )
        }

        AppTheme(isLightTheme = isLightTheme) {
            Navigator(MainScreen) { navigator ->
                FadeTransition(navigator)
            }
        }
    }
}
