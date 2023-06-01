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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hewei.wecompose.R
import com.hewei.wecompose.viewmodels.WeViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hewei.wecompose.data.User
import com.hewei.wecompose.ui.theme.WeComposeTheme


@Composable
fun ContactListTopBar() {
    WeTopBar(title = "通訊錄")
}

@Composable
fun ContactList(viewModel: WeViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .background(WeComposeTheme.colors.background)
            .fillMaxSize()
    ) {
        ContactListTopBar()
        Box {
            ContactList(viewModel.contacts)
        }
    }
}

// Composable 做為 function 也可以使用 kotlin 多載功能
@Composable
fun ContactList(contacts: List<User>) {
    LazyColumn(
        Modifier
            .background(WeComposeTheme.colors.listItem)
            .fillMaxWidth()
    ) {
        // 頂部常駐按鈕
        val buttons = listOf(
            User("contact_add", "新的朋友", R.drawable.ic_contact_add),
            User("contact_chat", "僅聊天", R.drawable.ic_contact_chat),
            User("contact_group", "群聊", R.drawable.ic_contact_group),
            User("contact_tag", "標籤", R.drawable.ic_contact_tag),
            User("contact_official", "公眾號", R.drawable.ic_contact_official),
        )

        itemsIndexed(buttons) { index, contact ->
            ContactListItem(contact)
            if (index < buttons.size - 1) {
                Divider(
                    modifier = Modifier.padding(start = 56.dp),
                    color = WeComposeTheme.colors.divider,
                    thickness = 0.8f.dp,
                )
            }
        }

        item {
            Text(
                "朋友",
                Modifier
                    .background(WeComposeTheme.colors.background)
                    .fillMaxWidth()
                    .padding(12.dp, 8.dp),
                fontSize = 14.sp,
                color = WeComposeTheme.colors.textSecondary
            )
        }

        // 朋友列表
        itemsIndexed(contacts) { index, contact ->
            ContactListItem(contact)
            if (index < contacts.size - 1) {
                Divider(
                    modifier = Modifier.padding(start = 56.dp),
                    color = WeComposeTheme.colors.divider,
                    thickness = 0.8f.dp
                )
            }
        }
    }
}

@Composable
fun ContactListItem(
    contact: User,
    modifier: Modifier = Modifier,
) {
    Row(
        Modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(contact.avatar),
            contentDescription = contact.name,
            modifier = Modifier
                .padding(12.dp, 8.dp, 8.dp, 8.dp)
                .size(36.dp)
                .clip(RoundedCornerShape(4.dp))
        )
        Text(
            text = contact.name,
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically),
            fontSize = 17.sp,
            color = WeComposeTheme.colors.textPrimary
        )
    }
}

@Preview
@Composable
fun ContactListTopBarPreviewNewYear() {
    WeComposeTheme(WeComposeTheme.Theme.NewYear) {
        ContactListTopBar()

    }
}

@Preview(showBackground = true)
@Composable
fun ContactListPreviewNewYear() {
    var users by remember {
        mutableStateOf(
            listOf( //List<User>
                User("ingwen", "英文老師", R.drawable.avatar_ing_wen),
                User("danialhan", "韓國瑜珈老師", R.drawable.avatar_danial_han),
                User("wayawa", "挖鴨挖老師", R.drawable.avatar_wa_ya_wa)
            )
        )
    }

    WeComposeTheme(WeComposeTheme.Theme.NewYear) {
        ContactList(users)
    }
}