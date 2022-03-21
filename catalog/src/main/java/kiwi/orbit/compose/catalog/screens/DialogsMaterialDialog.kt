package kiwi.orbit.compose.catalog.screens

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

object DialogsMaterialDialog : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        DialogsMaterialDialog(navigator::pop)
    }
}


@Suppress("Dependency")
@Composable
private fun DialogsMaterialDialog(
    onClose: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = onClose,
        title = { Text("Title") },
        text = { Text("Some message.") },
        confirmButton = {
            androidx.compose.material.TextButton(onClick = onClose) {
                Text("Ok")
            }
        }
    )
}
