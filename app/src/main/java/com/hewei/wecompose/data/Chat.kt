package com.hewei.wecompose.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class Chat (var friend: User, var msgs: MutableList<Msg>) {
}

class Msg (var from: User, var text: String, val time: String) {
    var read: Boolean by mutableStateOf(true)
}