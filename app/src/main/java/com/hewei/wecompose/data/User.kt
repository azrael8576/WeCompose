package com.hewei.wecompose.data

import androidx.annotation.DrawableRes
import com.hewei.wecompose.R

data class User (
    val id: String,
    val name: String,
    @DrawableRes val avatar: Int,
) {
    companion object {
        val Me: User = User("wei.he", "何宣緯", R.drawable.avatar_he_wei)
    }
}