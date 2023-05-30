package com.hewei.wecompose.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hewei.wecompose.R
import com.hewei.wecompose.ui.theme.WeComposeTheme

// 點擊事件將調用 onSelectedChange 回調，並將新選中的標籤作為參數。
@Composable
fun WeBottomBar(selected: Int, onSelectedChange: (Int) -> Unit) {
    Row(Modifier.background(WeComposeTheme.colors.bottomBar)) {
        TabItem(
            resId = if (selected == 0) R.drawable.ic_chats_filled else R.drawable.ic_chats_outlined,
            title = "聊天",
            tint = if (selected == 0) WeComposeTheme.colors.iconCurrent else WeComposeTheme.colors.icon,
            Modifier
                .weight(1f)
                .clickable {
                    // Modifier.clickable{} 等價 setOnClickListeners
                    onSelectedChange(0)
                }
        )
        TabItem(
            resId = if (selected == 1) R.drawable.ic_contacts_filled else R.drawable.ic_contacts_outlined,
            title = "通訊錄",
            tint = if (selected == 1) WeComposeTheme.colors.iconCurrent else WeComposeTheme.colors.icon,
            Modifier
                .weight(1f)
                .clickable {
                    // Modifier.clickable{} 等價 setOnClickListeners
                    onSelectedChange(1)
                }
        )
        TabItem(
            resId = if (selected == 2) R.drawable.ic_discover_filled else R.drawable.ic_discover_outlined,
            title = "發現",
            tint = if (selected == 2) WeComposeTheme.colors.iconCurrent else WeComposeTheme.colors.icon,
            Modifier
                .weight(1f)
                .clickable {
                    // Modifier.clickable{} 等價 setOnClickListeners
                    onSelectedChange(2)
                }
        )
        TabItem(
            resId = if (selected == 3) R.drawable.ic_me_filled else R.drawable.ic_me_outlined,
            title = "我",
            tint = if (selected == 3) WeComposeTheme.colors.iconCurrent else WeComposeTheme.colors.icon,
            Modifier
                .weight(1f)
                .clickable {
                    // Modifier.clickable{} 等價 setOnClickListeners
                    onSelectedChange(3)
                }
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

// 這是一個 Composable 預覽功能，用於在不同主題（此處為亮色主題）下展示 WeBottomBar 的外觀。
// 請注意，在 Composable 函數內無法直接使用 ViewModel。因此我們需要創建一個獨立的 State 變數並用 remember{} 函數保護它，來儲存選中的標籤。
@Preview(showBackground = true)
@Composable
fun WeBottomBarPreview() {
    WeComposeTheme(WeComposeTheme.Theme.Light) {
        // 在 Composable 函數內無法使用 ViewModel，需要直接創建 States 變數。並在外層使用 remember{} 包裹
        var selectedTab by remember {
            mutableStateOf(0)
        }
        WeBottomBar(selected = selectedTab) { selectedTab = it }
    }
}

// 這是一個 Composable 預覽功能，用於在不同主題（此處為暗色主題）下展示 WeBottomBar 的外觀。
// 請注意，在 Composable 函數內無法直接使用 ViewModel。因此我們需要創建一個獨立的 State 變數並用 remember{} 函數保護它，來儲存選中的標籤。
@Preview(showBackground = true)
@Composable
fun WeBottomBarPreviewDark() {
    WeComposeTheme(WeComposeTheme.Theme.Dark) {
        // 在 Composable 函數內無法使用 ViewModel，需要直接創建 States 變數。並在外層使用 remember{} 包裹
        var selectedTab by remember {
            mutableStateOf(0)
        }
        WeBottomBar(selected = selectedTab) { selectedTab = it }
    }
}

// 這是一個 Composable 預覽功能，用於在不同主題（此處為新年主題）下展示 WeBottomBar 的外觀。
// 請注意，在 Composable 函數內無法直接使用 ViewModel。因此我們需要創建一個獨立的 State 變數並用 remember{} 函數保護它，來儲存選中的標籤。
@Preview(showBackground = true)
@Composable
fun WeBottomBarPreviewNewYear() {
    WeComposeTheme(WeComposeTheme.Theme.NewYear) {
        var selectedTab by remember {
            mutableStateOf(0)
        }
        WeBottomBar(selected = selectedTab) { selectedTab = it }
    }
}