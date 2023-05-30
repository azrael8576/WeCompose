package com.hewei.wecompose.ui.theme

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Stable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.hewei.wecompose.ui.theme.WeComposeTheme.Theme.*

private val DarkColorScheme = WeComposeColors(
    bottomBar = Bw100Alpha01,
    background = BwBg0,
    listItem = BwBg20,
    divider = Bw0Alpha05,
    chatPage = Brand90,
    textPrimary = BwBg97,
    textSecondary = Bw0Alpha05,
    onBackground = Brand90,
    icon = BwBg97,
    iconCurrent = Brand90,
    badge = Red80,
    onBadge = Brand90,
    bubbleMe = Brand90,
    bubbleOthers = Brand90,
    textFieldBackground = Brand90,
    more = Brand90,
    chatPageBgAlpha = 0f,
)

private val LightColorScheme = WeComposeColors(
    bottomBar = BwBg97,
    background = Bw0Alpha01,
    listItem = Bw100,
    divider = Bw100Alpha05,
    chatPage = Brand90,
    textPrimary = Bw100Alpha01,
    textSecondary = Bw100Alpha05,
    onBackground = Brand90,
    icon = BwBg0,
    iconCurrent = Brand90,
    badge = Red80,
    onBadge = Brand90,
    bubbleMe = Brand90,
    bubbleOthers = Brand90,
    textFieldBackground = Brand90,
    more = Brand90,
    chatPageBgAlpha = 0f
)

private val NewYearColorScheme = WeComposeColors(
    bottomBar = Red90,
    background = Red80,
    listItem = Red90,
    divider = BwBg93,
    chatPage = Brand90,
    textPrimary = BwBg97,
    textSecondary = BwBg93,
    onBackground = Brand90,
    icon = BwBg97,
    iconCurrent = Brand90,
    badge = Orange170,
    onBadge = Brand90,
    bubbleMe = Brand90,
    bubbleOthers = Brand90,
    textFieldBackground = Brand90,
    more = Brand90,
    chatPageBgAlpha = 1f
)

private val LocalWeComposeColors = compositionLocalOf {
    LightColorScheme
}

object WeComposeTheme {
    val colors: WeComposeColors
        @Composable
        get() = LocalWeComposeColors.current
    enum class Theme {
        Light, Dark, NewYear
    }
}

@Stable
class WeComposeColors(
    bottomBar : Color,
    background : Color,
    listItem : Color,
    divider : Color,
    chatPage : Color,
    textPrimary : Color,
    textSecondary : Color,
    onBackground : Color,
    icon : Color,
    iconCurrent : Color,
    badge : Color,
    onBadge : Color,
    bubbleMe : Color,
    bubbleOthers : Color,
    textFieldBackground : Color,
    more : Color,
    chatPageBgAlpha : Float,
) {
    var bottomBar: Color by mutableStateOf(bottomBar)
        private set
    var background: Color by mutableStateOf(background)
        private set
    var listItem: Color by mutableStateOf(listItem)
        private set
    var divider: Color by mutableStateOf(divider)
        private set
    var chatPage: Color by mutableStateOf(chatPage)
        private set
    var textPrimary: Color by mutableStateOf(textPrimary)
        private set
    var textSecondary: Color by mutableStateOf(textSecondary)
        private set
    var onBackground: Color by mutableStateOf(onBackground)
        private set
    var icon: Color by mutableStateOf(icon)
        private set
    var iconCurrent: Color by mutableStateOf(iconCurrent)
        private set
    var badge: Color by mutableStateOf(badge)
        private set
    var onBadge: Color by mutableStateOf(onBadge)
        private set
    var bubbleMe: Color by mutableStateOf(bubbleMe)
        private set
    var bubbleOthers: Color by mutableStateOf(bubbleOthers)
        private set
    var textFieldBackground: Color by mutableStateOf(textFieldBackground)
        private set
    var more: Color by mutableStateOf(more)
        private set
    var chatPageBgAlpha: Float by mutableStateOf(chatPageBgAlpha)
        private set

}


@Composable
fun WeComposeTheme(
    theme: WeComposeTheme.Theme = Light,
    content: @Composable () -> Unit
) {
    val targetColors = when (theme) {
        WeComposeTheme.Theme.Light -> LightColorScheme
        WeComposeTheme.Theme.Dark -> DarkColorScheme
        WeComposeTheme.Theme.NewYear -> NewYearColorScheme
    }

    var bottomBar = animateColorAsState(targetColors.bottomBar, TweenSpec(600))
    var background = animateColorAsState(targetColors.background, TweenSpec(600))
    var listItem = animateColorAsState(targetColors.listItem, TweenSpec(600))
    var divider = animateColorAsState(targetColors.divider, TweenSpec(600))
    var chatPage = animateColorAsState(targetColors.chatPage, TweenSpec(600))
    var textPrimary = animateColorAsState(targetColors.textPrimary, TweenSpec(600))
    var textSecondary = animateColorAsState(targetColors.textSecondary, TweenSpec(600))
    var onBackground = animateColorAsState(targetColors.onBackground, TweenSpec(600))
    var icon = animateColorAsState(targetColors.icon, TweenSpec(600))
    var iconCurrent = animateColorAsState(targetColors.iconCurrent, TweenSpec(600))
    var badge = animateColorAsState(targetColors.badge, TweenSpec(600))
    var onBadge = animateColorAsState(targetColors.onBadge, TweenSpec(600))
    var bubbleMe = animateColorAsState(targetColors.bubbleMe, TweenSpec(600))
    var bubbleOthers = animateColorAsState(targetColors.bubbleOthers, TweenSpec(600))
    var textFieldBackground = animateColorAsState(targetColors.textFieldBackground, TweenSpec(600))
    var more = animateColorAsState(targetColors.more, TweenSpec(600))
    var chatPageBgAlpha = animateFloatAsState(targetColors.chatPageBgAlpha, TweenSpec(600))

    val colors = WeComposeColors(
        bottomBar = bottomBar.value,
        background = background.value,
        listItem = listItem.value,
        divider = divider.value,
        chatPage = chatPage.value,
        textPrimary = textPrimary.value,
        textSecondary = textSecondary.value,
        onBackground = onBackground.value,
        icon = icon.value,
        iconCurrent = iconCurrent.value,
        badge = badge.value,
        onBadge = onBadge.value,
        bubbleMe = bubbleMe.value,
        bubbleOthers = bubbleOthers.value,
        textFieldBackground = textFieldBackground.value,
        more = more.value,
        chatPageBgAlpha = chatPageBgAlpha.value,
    )

    CompositionLocalProvider(LocalWeComposeColors provides colors) {
        MaterialTheme(
            shapes = shapes,
            content = content,
        )
    }
}