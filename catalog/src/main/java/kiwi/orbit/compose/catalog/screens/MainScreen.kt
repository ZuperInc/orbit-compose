package kiwi.orbit.compose.catalog.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.rounded.Announcement
import androidx.compose.material.icons.rounded.Article
import androidx.compose.material.icons.rounded.Ballot
import androidx.compose.material.icons.rounded.BrightnessMedium
import androidx.compose.material.icons.rounded.CheckBox
import androidx.compose.material.icons.rounded.FormatSize
import androidx.compose.material.icons.rounded.Keyboard
import androidx.compose.material.icons.rounded.LabelImportant
import androidx.compose.material.icons.rounded.MenuOpen
import androidx.compose.material.icons.rounded.Palette
import androidx.compose.material.icons.rounded.SmartButton
import androidx.compose.material.icons.rounded.ToggleOn
import androidx.compose.material.icons.rounded.WebAsset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import kiwi.orbit.compose.catalog.LightTheme
import kiwi.orbit.compose.icons.Icons
import kiwi.orbit.compose.ui.OrbitTheme
import kiwi.orbit.compose.ui.controls.Card
import kiwi.orbit.compose.ui.controls.Icon
import kiwi.orbit.compose.ui.controls.IconButton
import kiwi.orbit.compose.ui.controls.Scaffold
import kiwi.orbit.compose.ui.controls.Text
import kiwi.orbit.compose.ui.controls.TopAppBarLarge
import kiwi.orbit.compose.ui.foundation.ProvideMergedTextStyle
import androidx.compose.material.icons.Icons.Rounded as MaterialIcons

object MainScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        MainScreen(
            onNavigate = { navigator.push(it) },
            onToggleTheme = { LightTheme.value = !LightTheme.value },
        )
    }
}

@Composable
fun MainScreen(
    onNavigate: (screen: Screen) -> Unit,
    onToggleTheme: () -> Unit,
) {
    val foundation = listOf<Triple<String, @Composable () -> Unit, Screen>>(
        Triple("Colors", { Icon(MaterialIcons.Palette, null) }, ColorsScreen),
        Triple("Icons", { Icon(Icons.Airplane, null) }, IconsScreen),
        Triple("Illustrations", { Icon(Icons.Gallery, null) }, IllustrationsScreen),
        Triple("Typography", { Icon(MaterialIcons.FormatSize, null) }, TypographyScreen),
    )

    val controls = listOf<Triple<String, @Composable () -> Unit, Screen>>(
        Triple("Alert", { Icon(Icons.Alert, null) }, AlertScreen),
        Triple("Badge", { Icon(Icons.Deals, null) }, BadgeScreen),
        Triple("Button", { Icon(MaterialIcons.SmartButton, null) }, ButtonScreen),
        Triple("Cards / Tiles", { Icon(MaterialIcons.Article, null) }, CardsScreen),
        Triple("Checkbox", { Icon(MaterialIcons.CheckBox, null) }, CheckboxScreen),
        Triple("Choice Tile", { Icon(MaterialIcons.Ballot, null) }, ChoiceTileScreen),
        Triple("Dialogs", { Icon(Icons.Chat, null) }, DialogsScreen),
        Triple("Radio", { Icon(Icons.CircleFilled, null) }, RadioScreen),
        Triple("Seat", { Icon(Icons.Seat, null) }, SeatScreen),
        Triple("Select Field", { Icon(MaterialIcons.MenuOpen, null) }, SelectFieldScreen),
        Triple("Stepper", { Icon(Icons.PlusCircle, null) }, StepperScreen),
        Triple("Switch", { Icon(MaterialIcons.ToggleOn, null) }, SwitchScreen),
        Triple("Tag", { Icon(MaterialIcons.LabelImportant, null) }, TagScreen),
        Triple("Text Field", { Icon(MaterialIcons.Keyboard, null) }, TextFieldScreen),
        Triple("Toast", { Icon(MaterialIcons.Announcement, null) }, ToastScreen),
        Triple("TopAppBar", { Icon(MaterialIcons.WebAsset, null) }, TopAppBarScreen()),
    )

    Scaffold(
        topBar = {
            TopAppBarLarge(
                title = { Text("Orbit Compose Catalog") },
                actions = {
                    IconButton(onClick = onToggleTheme) {
                        Icon(MaterialIcons.BrightnessMedium, contentDescription = null)
                    }
                },
            )
        },
        backgroundColor = OrbitTheme.colors.surface.background,
    ) { contentPadding ->
        BoxWithConstraints {
            val columns = (maxWidth / 180.dp).toInt().coerceAtLeast(1)
            Column(
                Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(contentPadding)
            ) {
                Spacer(Modifier.size(16.dp))
                CardsList("Foundation", foundation, columns, onNavigate)
                CardsList("Controls", controls, columns, onNavigate)
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun CardsList(
    title: String,
    items: List<Triple<String, @Composable () -> Unit, Screen>>,
    columns: Int,
    onNavigate: (screen: Screen) -> Unit,
) {
    Text(
        text = title,
        style = OrbitTheme.typography.title3,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 4.dp)
    )
    Column(Modifier.padding(horizontal = 12.dp, vertical = 8.dp)) {
        for (rowItems in items.chunked(columns)) {
            Row {
                Items(rowItems, onNavigate)
                val missingColumns = columns - rowItems.size
                if (missingColumns > 0) {
                    Spacer(Modifier.weight(missingColumns.toFloat()))
                }
            }
        }
    }
}

@Composable
private fun RowScope.Items(
    rowItems: List<Triple<String, @Composable () -> Unit, Screen>>,
    onNavigate: (screen: Screen) -> Unit,
) {
    for (item in rowItems) {
        Item(item.first, item.second) { onNavigate(item.third) }
    }
}

@Composable
private fun RowScope.Item(title: String, icon: @Composable () -> Unit, onClick: () -> Unit) {
    Card(
        Modifier
            .padding(4.dp)
            .weight(1f),
    ) {
        Row(
            Modifier
                .clip(OrbitTheme.shapes.normal)
                .clickable(onClick = onClick)
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            ProvideMergedTextStyle(OrbitTheme.typography.bodyNormalMedium) {
                icon()
                Spacer(Modifier.size(8.dp))
                Text(title)
            }
        }
    }
}
