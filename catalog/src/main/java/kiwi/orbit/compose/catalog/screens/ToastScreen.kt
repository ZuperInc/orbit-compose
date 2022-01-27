package kiwi.orbit.compose.catalog.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import kiwi.orbit.compose.catalog.Screen
import kiwi.orbit.compose.icons.Icons
import kiwi.orbit.compose.ui.controls.ButtonSecondary
import kiwi.orbit.compose.ui.controls.Text
import kiwi.orbit.compose.ui.controls.ToastHostState
import kotlinx.coroutines.launch

@Composable
fun ToastScreen(
    onUpClick: () -> Unit,
) {
    val toastHostState = remember { ToastHostState() }
    val scope = rememberCoroutineScope()
    Screen(
        title = "Toast",
        onUpClick = onUpClick,
        toastHostState = toastHostState,
    ) {
        Box(
            Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            ToastScreenInner { message, icon ->
                scope.launch {
                    toastHostState.showToast(message, icon)
                }
            }
        }
    }
}

@Composable
private fun ToastScreenInner(
    onToast: (String, @Composable (() -> Painter)?) -> Unit,
) {
    Column(
        Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp, alignment = Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ButtonSecondary(
            onClick = {
                onToast("You’re signed in as jon.snow@wall.7k.") { Icons.CheckCircle }
            },
        ) { Text("Toast – signed in") }

        ButtonSecondary(
            onClick = {
                onToast("Price alert was removed.") { Icons.NotificationOff }
            },
        ) { Text("Toast – price alert") }

        ButtonSecondary(
            onClick = {
                onToast("We’ll notify you when the price changes.") { Icons.Notification }
            },
        ) { Text("Toast – price alert created") }

        ButtonSecondary(
            onClick = {
                onToast(
                    "On mobile there’s always a fixed width to make the Toast stand out a bit more.",
                    null
                )
            },
        ) { Text("Toast – long message") }

        ButtonSecondary(
            onClick = {
                onToast("On mobile there’s always a fixed width to make the Toast stand out a bit more.") { Icons.AirplaneLanding }
            },
        ) { Text("Toast – long message 2") }
    }
}
