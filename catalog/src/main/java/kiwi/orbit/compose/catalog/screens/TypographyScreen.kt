package kiwi.orbit.compose.catalog.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kiwi.orbit.compose.catalog.Screen
import kiwi.orbit.compose.ui.OrbitTheme
import kiwi.orbit.compose.ui.controls.Text

@Composable
fun TypographyScreen(onNavigateUp: () -> Unit) {
    Screen(
        title = "Typography",
        onNavigateUp = onNavigateUp,
    ) { contentPadding ->
        Box(
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(contentPadding)
        ) {
            TypographyScreenInner()
        }
    }
}

@Preview
@Composable
private fun TypographyScreenInner() {
    Column(Modifier.padding(16.dp)) {
        Text("Display Title", style = OrbitTheme.typography.displayTitle)
        Text("Display Subtitle", style = OrbitTheme.typography.displaySubtitle)
        Text("Title 1", style = OrbitTheme.typography.title1)
        Text("Title 2", style = OrbitTheme.typography.title2)
        Text("Title 3", style = OrbitTheme.typography.title3)
        Text("Title 4", style = OrbitTheme.typography.title4)
        Text("Title 5", style = OrbitTheme.typography.title5)
        Text("Body Large", style = OrbitTheme.typography.bodyLarge)
        Text("Body Normal", style = OrbitTheme.typography.bodyNormal)
        Text("Body Small", style = OrbitTheme.typography.bodySmall)
    }
}
