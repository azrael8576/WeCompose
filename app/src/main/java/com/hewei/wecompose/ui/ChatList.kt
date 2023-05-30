package com.hewei.wecompose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hewei.wecompose.data.Chat
import com.hewei.wecompose.ui.theme.WeComposeTheme

@Composable
fun ChatList(chats: List<Chat>) {
    // 等價 RecyclerView
    Box(
        Modifier
            .background(color = WeComposeTheme.colors.background)
            .fillMaxSize()
    ) {
        LazyColumn(
            Modifier
                .background(color = WeComposeTheme.colors.listItem)
        ) {
            // 使用 itemsIndexed 而非 items 以遍歷時獲取最後一筆
            itemsIndexed(chats) { index, chat ->
                ChatListItem(chat)
                if (index < chats.lastIndex) {
                    Divider(
                        modifier = Modifier.padding(start = 68.dp),
                        color = WeComposeTheme.colors.divider,
                        thickness = 1.dp,
                    )
                }
            }
        }
    }
}

@Composable
private fun ChatListItem(chat: Chat) {
    Row(
        Modifier.fillMaxWidth(),
    ) {
        Image(
            painter = painterResource(id = chat.friend.avatar),
            contentDescription = chat.friend.name,
            modifier = Modifier
                .padding(8.dp)
                .size(48.dp)
                .unread(!chat.message.last().read, WeComposeTheme.colors.badge)
                .clip(RoundedCornerShape(4.dp))
        )
        Column(
            Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        ) {
            Text(chat.friend.name, fontSize = 17.sp, color = WeComposeTheme.colors.textPrimary)
            Text(
                chat.message.last().text,
                fontSize = 14.sp,
                color = WeComposeTheme.colors.textSecondary
            )
        }
        Text(
            chat.message.last().time,
            Modifier.padding(8.dp, 8.dp, 12.dp, 8.dp),
            fontSize = 11.sp, color = WeComposeTheme.colors.textSecondary
        )
    }
}

// 自訂未讀紅點
fun Modifier.unread(show: Boolean, color: Color): Modifier = this.drawWithContent {
    drawContent()
    if (show) {
        drawCircle(color, 5.dp.toPx(), Offset(size.width - 1.dp.toPx(), 1.dp.toPx()))
    }
}