package com.hewei.wecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hewei.wecompose.ui.ChatList
import com.hewei.wecompose.ui.WeBottomBar
import com.hewei.wecompose.ui.theme.WeComposeTheme
import com.hewei.wecompose.viewmodels.WeViewModel

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // 我們創建了一個 WeViewModel 實例（需要在 build.gradle 文件中添加 lifecycle.viewmodel.compose.viewModel 依賴）
            val viewModel: WeViewModel = viewModel()

            WeComposeTheme(viewModel.theme) {
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
        }
    }
}