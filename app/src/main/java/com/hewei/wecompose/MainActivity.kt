package com.hewei.wecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hewei.wecompose.ui.ChatPage
import com.hewei.wecompose.ui.Home
import com.hewei.wecompose.ui.theme.WeComposeTheme
import com.hewei.wecompose.viewmodels.WeViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: WeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeComposeTheme(viewModel.theme) {
                Box {
                    Home(viewModel)
                    ChatPage()
                }
            }
        }
    }

    override fun onBackPressed() {
        if (!viewModel.endChat()) {
            super.onBackPressed()
        }
    }
}