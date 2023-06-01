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
                    Msg(
                        User("ingwen", "英文老師", R.drawable.avatar_ing_wen),
                        "徵：新四濟高端戰士",
                        "14:20"
                    ),
                    Msg(
                        User.Me,
                        "安安我想領失業補助",
                        "14:21"
                    ),
                    Msg(
                        User("ingwen", "英文老師", R.drawable.avatar_ing_wen),
                        "勞工是我心中最軟的一塊！",
                        "14:22"
                    ),
                    Msg(
                        User.Me,
                        "我想租社會住宅",
                        "14:23"
                    ),
                    Msg(
                        User("ingwen", "英文老師", R.drawable.avatar_ing_wen),
                        "\uD83E\uDDA2…勞工是我心中最軟的一塊！",
                        "14:25"
                    ),
                )
            ),
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
                        User.Me,
                        "迪士尼！",
                        "14:28"
                    ),
                    Msg(
                        User("danialhan", "韓國瑜珈老師", R.drawable.avatar_danial_han),
                        "招商迪士尼！！！挖石油！",
                        "14:29"
                    ).apply { read = false },
                )
            )
        )
    )

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

    fun boom(chat: Chat) {
        chat.msgs.add(Msg(User.Me, "\uD83D\uDCA3", "15:10").apply { read = true })
    }
}