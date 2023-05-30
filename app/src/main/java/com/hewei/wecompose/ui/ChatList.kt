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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hewei.wecompose.R
import com.hewei.wecompose.data.Chat
import com.hewei.wecompose.data.Msg
import com.hewei.wecompose.data.User
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

@Preview(showBackground = true)
@Composable
fun ChatListPreview() {
    var chats by remember {
        mutableStateOf(
            listOf( //List<Chat>
                Chat(
                    friend = User("ingwen", "英文老師", R.drawable.avatar_ing_wen),
                    mutableStateListOf(
                        Msg(User("ingwen", "英文老師", R.drawable.avatar_ing_wen), "勞工是我心中最軟的一塊", "14:20"),
                        Msg(User("ingwen", "英文老師", R.drawable.avatar_ing_wen), "徵：新四濟高端戰士", "14:20"),
                    )
                ),
                Chat(
                    friend = User("danialhan", "韓國瑜珈老師", R.drawable.avatar_danial_han),
                    mutableStateListOf(
                        Msg(User("danialhan", "韓國瑜珈老師", R.drawable.avatar_danial_han), "發大財", "14:28"),
                        Msg(User("danialhan", "韓國瑜珈老師", R.drawable.avatar_danial_han), "挖石油！", "14:28"),
                        Msg(User("danialhan", "韓國瑜珈老師", R.drawable.avatar_danial_han), "發大財！！", "14:28").apply { read = false },
                    )
                )
            )
        )
    }

    ChatList(
        chats
    )
}


@Preview(showBackground = true)
@Composable
fun ChatListItemPreview() {
    var chat by remember {
        mutableStateOf(
            Chat(
                friend = User("danialhan", "韓國瑜珈老師", R.drawable.avatar_danial_han),
                mutableStateListOf(
                    Msg(
                        User("danialhan", "韓國瑜珈老師", R.drawable.avatar_danial_han),
                        "發大財",
                        "14:28"
                    ),
                    Msg(
                        User("danialhan", "韓國瑜珈老師", R.drawable.avatar_danial_han),
                        "挖石油！",
                        "14:28"
                    ),
                    Msg(
                        User("danialhan", "韓國瑜珈老師", R.drawable.avatar_danial_han),
                        "發大財！！",
                        "14:28"
                    ).apply { read = false },
                )
            )
        )
    }
    ChatListItem(
        chat
    )
}