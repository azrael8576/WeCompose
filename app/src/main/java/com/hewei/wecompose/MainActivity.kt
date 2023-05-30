package com.hewei.wecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import com.hewei.wecompose.ui.WeBottomBar
import com.hewei.wecompose.ui.theme.WeComposeTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeComposeTheme {
                Column {
                    WeBottomBar(selected = 0)
                }
            }
        }
    }
}