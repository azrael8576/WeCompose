package com.hewei.wecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
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
import com.hewei.wecompose.ui.theme.Brand90
import com.hewei.wecompose.ui.theme.BwBg0
import com.hewei.wecompose.ui.theme.WeComposeTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeComposeTheme {
                Column {
                    WeBottomBar(selected = 0)
                }
            }
        }
    }
}

@Composable
private fun WeBottomBar(selected: Int) {
    Row {
        TabItem(
            resId = if (selected == 0) R.drawable.ic_chats_filled else R.drawable.ic_chats_outlined,
            title = "聊天",
            tint = if (selected == 0) Brand90 else BwBg0,
            Modifier.weight(1f)
        )
        TabItem(
            resId = if (selected == 1) R.drawable.ic_contacts_filled else R.drawable.ic_contacts_outlined,
            title = "通訊錄",
            tint = if (selected == 1) Brand90 else BwBg0,
            Modifier.weight(1f)
        )
        TabItem(
            resId = if (selected == 2) R.drawable.ic_discover_filled else R.drawable.ic_discover_outlined,
            title = "發現",
            tint = if (selected == 2) Brand90 else BwBg0,
            Modifier.weight(1f)
        )
        TabItem(
            resId = if (selected == 3) R.drawable.ic_me_filled else R.drawable.ic_me_outlined,
            title = "我",
            tint = if (selected == 3) Brand90 else BwBg0,
            Modifier.weight(1f)
        )
    }
}

@Composable
private fun TabItem(@DrawableRes resId: Int, title: String, tint: Color, modifier: Modifier = Modifier) {
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
        tint = Brand90
    )
}

@Preview(showBackground = true)
@Composable
fun WeBottomBarPreview() {
    WeBottomBar(selected = 0)
}