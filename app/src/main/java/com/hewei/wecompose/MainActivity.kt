package com.hewei.wecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hewei.wecompose.ui.WeBottomBar
import com.hewei.wecompose.ui.theme.WeComposeTheme
import com.hewei.wecompose.viewmodels.WeViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeComposeTheme {
                Column {
                    // 我們創建了一個 WeViewModel 實例（需要在 build.gradle 文件中添加 lifecycle.viewmodel.compose.viewModel 依賴）
                    val viewModel: WeViewModel = viewModel()

                    WeBottomBar(selected = viewModel.selectedTab) {
                        viewModel.selectedTab = it
                    }
                }
            }
        }
    }
}