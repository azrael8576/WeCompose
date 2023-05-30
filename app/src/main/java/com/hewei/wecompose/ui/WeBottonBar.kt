package com.hewei.wecompose.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hewei.wecompose.R
import com.hewei.wecompose.ui.theme.WeComposeTheme


@Composable
fun WeBottomBar(selected: Int) {
    Row(Modifier.background(WeComposeTheme.colors.bottomBar)) {
        TabItem(
            resId = if (selected == 0) R.drawable.ic_chats_filled else R.drawable.ic_chats_outlined,
            title = "聊天",
            tint = if (selected == 0) WeComposeTheme.colors.iconCurrent else WeComposeTheme.colors.icon,
            Modifier.weight(1f)
        )
        TabItem(
            resId = if (selected == 1) R.drawable.ic_contacts_filled else R.drawable.ic_contacts_outlined,
            title = "通訊錄",
            tint = if (selected == 1) WeComposeTheme.colors.iconCurrent else WeComposeTheme.colors.icon,
            Modifier.weight(1f)
        )
        TabItem(
            resId = if (selected == 2) R.drawable.ic_discover_filled else R.drawable.ic_discover_outlined,
            title = "發現",
            tint = if (selected == 2) WeComposeTheme.colors.iconCurrent else WeComposeTheme.colors.icon,
            Modifier.weight(1f)
        )
        TabItem(
            resId = if (selected == 3) R.drawable.ic_me_filled else R.drawable.ic_me_outlined,
            title = "我",
            tint = if (selected == 3) WeComposeTheme.colors.iconCurrent else WeComposeTheme.colors.icon,
            Modifier.weight(1f)
        )
    }
}

@Composable
fun TabItem(@DrawableRes resId: Int, title: String, tint: Color, modifier: Modifier = Modifier) {
    Column(
        modifier.padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(painterResource(id = resId), title, Modifier.size(24.dp), tint = tint)
        Text(text = title, fontSize = 11.sp, color = tint)
    }
}

@Preview(showBackground = true)
@Composable
fun TabItemPreview() {
    TabItem(
        resId = R.drawable.ic_chats_filled,
        title = "聊天",
        tint = WeComposeTheme.colors.iconCurrent
    )
}

@Preview(showBackground = true)
@Composable
fun WeBottomBarPreview() {
    WeComposeTheme(WeComposeTheme.Theme.Light) {
        WeBottomBar(selected = 0)
    }
}

@Preview(showBackground = true)
@Composable
fun WeBottomBarPreviewDark() {
    WeComposeTheme(WeComposeTheme.Theme.Dark) {
        WeBottomBar(selected = 0)
    }
}

@Preview(showBackground = true)
@Composable
fun WeBottomBarPreviewNewYear() {
    WeComposeTheme(WeComposeTheme.Theme.NewYear) {
        WeBottomBar(selected = 0)
    }
}