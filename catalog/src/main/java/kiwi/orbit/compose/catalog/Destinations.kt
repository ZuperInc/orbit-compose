package kiwi.orbit.compose.catalog

import com.kiwi.navigationcompose.typed.Destination
import kotlinx.serialization.Serializable

sealed interface Destinations : Destination {
    @Serializable
    object Main : Destinations

    @Serializable
    object Colors : Destinations

    @Serializable
    object Icons : Destinations

    @Serializable
    object Illustrations : Destinations

    @Serializable
    object Typography : Destinations

    @Serializable
    object Alert : Destinations

    @Serializable
    object Badge : Destinations

    @Serializable
    object Button : Destinations

    @Serializable
    object Checkbox : Destinations

    @Serializable
    object ChoiceTile : Destinations

    @Serializable
    object Dialog : Destinations

    @Serializable
    object DialogMaterial : Destinations

    @Serializable
    object DialogOrbit : Destinations

    @Serializable
    object EmptyState : Destinations

    @Serializable
    object KeyValue : Destinations

    @Serializable
    object LinearProgressIndicator : Destination

    @Serializable
    object List : Destinations

    @Serializable
    object ListChoice : Destinations

    @Serializable
    object Loading : Destinations

    @Serializable
    object Radio : Destinations

    @Serializable
    object PillButton : Destinations

    @Serializable
    object Seat : Destinations

    @Serializable
    object SegmentedSwitch : Destinations

    @Serializable
    object SelectField : Destinations

    @Serializable
    object Stepper : Destinations

    @Serializable
    object SurfaceCard : Destinations

    @Serializable
    object Switch : Destinations

    @Serializable
    object Tag : Destinations

    @Serializable
    object TextField : Destinations

    @Serializable
    object Toast : Destinations

    @Serializable
    object TopAppBar : Destinations
}
