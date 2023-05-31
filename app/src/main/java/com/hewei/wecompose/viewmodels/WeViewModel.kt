package com.hewei.wecompose.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.hewei.wecompose.R
import com.hewei.wecompose.data.Chat
import com.hewei.wecompose.data.Msg
import com.hewei.wecompose.data.User
import com.hewei.wecompose.ui.theme.WeComposeTheme

class WeViewModel : ViewModel() {
    var chats by mutableStateOf(
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

    var selectedTab by mutableStateOf(0)
    var theme by mutableStateOf(WeComposeTheme.Theme.Light)
    var currentChat: Chat? by mutableStateOf(null)
    var chatting by mutableStateOf(false)

    fun startChat(chat: Chat) {
        chatting = true
        currentChat = chat
    }

    fun endChat(): Boolean {
        if (chatting) {
            chatting = false
            return true
        }
        return false
    }
}