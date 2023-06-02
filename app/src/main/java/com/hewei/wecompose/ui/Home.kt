package com.hewei.wecompose.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.hewei.wecompose.viewmodels.WeViewModel
import kotlinx.coroutines.launch

@Composable
@OptIn(ExperimentalFoundationApi::class)
fun Home(viewModel: WeViewModel) {
    Column {
        // 等價 ViewPager
        val pagerState = rememberPagerState()
        HorizontalPager(pageCount = 4, Modifier.weight(1f), state = pagerState) { page ->
            // Our page content
            when (page) {
                0 -> ChatList(viewModel.chats)
                1 -> ContactList()
                2 -> DiscoveryList()
                3 -> MeList()
            }
        }

        // scroll to page
        val coroutineScope = rememberCoroutineScope()
        WeBottomBar(selected = pagerState.currentPage) { page ->
            coroutineScope.launch {
                // Call scroll to on pagerState
                pagerState.scrollToPage(page)
            }
        }
    }
}