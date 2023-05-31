package com.hewei.wecompose.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hewei.wecompose.viewmodels.WeViewModel

@Composable
@OptIn(ExperimentalFoundationApi::class)
fun Home(viewModel: WeViewModel) {
    Column {
        // 等價 ViewPager
        HorizontalPager(pageCount = 4, Modifier.weight(1f)) { page ->
            when (page) {
                0 -> ChatList(viewModel.chats)
                1 -> Box(modifier = Modifier.fillMaxSize())
                2 -> Box(modifier = Modifier.fillMaxSize())
                3 -> Box(modifier = Modifier.fillMaxSize())
            }
        }
        WeBottomBar(selected = viewModel.selectedTab) {
            viewModel.selectedTab = it
        }
    }
}