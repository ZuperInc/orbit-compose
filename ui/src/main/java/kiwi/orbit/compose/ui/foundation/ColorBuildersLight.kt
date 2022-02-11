package kiwi.orbit.compose.ui.foundation

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import kiwi.orbit.compose.ui.foundation.tokens.ColorTokens

public fun lightColors(
    surface: SurfaceColors = lightSurfaceColors(),
    content: ContentColors = lightContentColors(),
    primary: FeatureColors = lightPrimaryColors(),
    interactive: FeatureColors = lightInteractiveColors(),
    success: FeatureColors = lightSuccessColors(),
    warning: FeatureColors = lightWarningColors(),
    critical: FeatureColors = lightCriticalColors(),
    bundle: BundleColors = lightBundleColors(),
): Colors = Colors(
    surface = surface,
    content = content,
    primary = primary,
    interactive = interactive,
    success = success,
    warning = warning,
    critical = critical,
    bundle = bundle,
    isLight = true,
)

public fun lightSurfaceColors(
    main: Color = ColorTokens.White,
    background: Color = ColorTokens.CloudLight,
    subtle: Color = ColorTokens.CloudNormal,
    strong: Color = ColorTokens.CloudDark,
    disabled: Color = ColorTokens.CloudDarker,
): SurfaceColors = SurfaceColors(
    main = main,
    background = background,
    subtle = subtle,
    strong = strong,
    disabled = disabled,
)

public fun lightContentColors(
    normal: Color = ColorTokens.InkNormal,
    minor: Color = ColorTokens.InkLight,
    subtle: Color = ColorTokens.InkLighter,
    highlight: Color = ColorTokens.ProductDark,
    disabled: Color = ColorTokens.CloudDarkerHover,
): ContentColors = ContentColors(
    normal = normal,
    minor = minor,
    subtle = subtle,
    highlight = highlight,
    disabled = disabled,
)

public fun lightPrimaryColors(
    main: Color = ColorTokens.ProductNormal,
    mainAlt: Color = ColorTokens.ProductNormalHover,
    subtle: Color = ColorTokens.ProductLight,
    subtleAlt: Color = ColorTokens.ProductLightHover,
    strong: Color = ColorTokens.ProductDark,
    onMain: Color = ColorTokens.White,
): FeatureColors = FeatureColors(
    main = main,
    mainAlt = mainAlt,
    subtle = subtle,
    subtleAlt = subtleAlt,
    strong = strong,
    onMain = onMain,
)

public fun lightInteractiveColors(
    main: Color = ColorTokens.BlueNormal,
    mainAlt: Color = ColorTokens.BlueNormalHover,
    subtle: Color = ColorTokens.BlueLight,
    subtleAlt: Color = ColorTokens.BlueLightHover,
    strong: Color = ColorTokens.BlueDark,
    onMain: Color = ColorTokens.White,
): FeatureColors = FeatureColors(
    main = main,
    mainAlt = mainAlt,
    subtle = subtle,
    subtleAlt = subtleAlt,
    strong = strong,
    onMain = onMain,
)

public fun lightSuccessColors(
    main: Color = ColorTokens.GreenNormal,
    mainAlt: Color = ColorTokens.GreenNormalHover,
    subtle: Color = ColorTokens.GreenLight,
    subtleAlt: Color = ColorTokens.GreenLightHover,
    strong: Color = ColorTokens.GreenDark,
    onMain: Color = ColorTokens.White,
): FeatureColors = FeatureColors(
    main = main,
    mainAlt = mainAlt,
    subtle = subtle,
    subtleAlt = subtleAlt,
    strong = strong,
    onMain = onMain,
)

public fun lightWarningColors(
    main: Color = ColorTokens.OrangeNormal,
    mainAlt: Color = ColorTokens.OrangeNormalHover,
    subtle: Color = ColorTokens.OrangeLight,
    subtleAlt: Color = ColorTokens.OrangeLightHover,
    strong: Color = ColorTokens.OrangeDark,
    onMain: Color = ColorTokens.White,
): FeatureColors = FeatureColors(
    main = main,
    mainAlt = mainAlt,
    subtle = subtle,
    subtleAlt = subtleAlt,
    strong = strong,
    onMain = onMain,
)

public fun lightCriticalColors(
    main: Color = ColorTokens.RedNormal,
    mainAlt: Color = ColorTokens.RedNormalHover,
    subtle: Color = ColorTokens.RedLight,
    subtleAlt: Color = ColorTokens.RedLightHover,
    strong: Color = ColorTokens.RedDark,
    onMain: Color = ColorTokens.White,
): FeatureColors = FeatureColors(
    main = main,
    mainAlt = mainAlt,
    subtle = subtle,
    subtleAlt = subtleAlt,
    strong = strong,
    onMain = onMain,
)

public fun lightBundleColors(
    basic: Color = ColorTokens.BundleBasic,
    basicGradient: Brush = bundleLinearGradient(ColorTokens.BundleBasicStart, ColorTokens.BundleBasicEnd),
    medium: Color = ColorTokens.BundleMedium,
    mediumGradient: Brush = bundleLinearGradient(ColorTokens.BundleMediumStart, ColorTokens.BundleMediumEnd),
    top: Color = ColorTokens.InkNormal,
    topGradient: Brush = bundleLinearGradient(ColorTokens.BundleTopStart, ColorTokens.BundleTopEnd),
    onBasic: Color = ColorTokens.White,
    onMedium: Color = ColorTokens.White,
    onTop: Color = ColorTokens.White,
): BundleColors = BundleColors(
    basic = basic,
    basicGradient = basicGradient,
    medium = medium,
    mediumGradient = mediumGradient,
    top = top,
    topGradient = topGradient,
    onBasic = onBasic,
    onMedium = onMedium,
    onTop = onTop,
)
