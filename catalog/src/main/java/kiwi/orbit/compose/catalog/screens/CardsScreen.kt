package kiwi.orbit.compose.catalog.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kiwi.orbit.compose.catalog.Screen
import kiwi.orbit.compose.illustrations.Illustrations
import kiwi.orbit.compose.ui.OrbitTheme
import kiwi.orbit.compose.ui.controls.Card
import kiwi.orbit.compose.ui.controls.Separator
import kiwi.orbit.compose.ui.controls.Text

@Destination
@Composable
fun CardsScreen(navigator: DestinationsNavigator) {
    Screen(
        title = "Cards / Tiles",
        onUpClick = navigator::navigateUp,
        withBackground = false,
    ) {
        Box(
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(it)
        ) {
            CardScreenInner()
        }
    }
}

@Preview
@Composable
private fun CardScreenInner() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        var state by remember { mutableStateOf(true) }

        Card(Modifier.fillMaxWidth()) {
            Box(Modifier.padding(16.dp)) {
                Text("Basic card")
            }
        }

        Separator()
        Text("Selectable cards")

        Card(
            onClick = { state = true },
            border = if (state) {
                BorderStroke(2.dp, OrbitTheme.colors.interactive.main)
            } else null,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Image(Illustrations.AirportShuttle, contentDescription = null)
        }

        Card(
            onClick = { state = false },
            border = if (!state) {
                BorderStroke(2.dp, OrbitTheme.colors.interactive.main)
            } else null,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Image(Illustrations.AirHelp, contentDescription = null)
        }
    }
}
