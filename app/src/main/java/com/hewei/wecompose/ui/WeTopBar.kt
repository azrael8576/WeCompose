package com.hewei.wecompose.ui

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hewei.wecompose.R
import com.hewei.wecompose.ui.theme.WeComposeTheme
import com.hewei.wecompose.viewmodels.WeViewModel

@Composable
fun WeTopBar(title: String, onBackClick: (() -> Unit)? = null) {
    Box(
        Modifier
            .background(WeComposeTheme.colors.background)
            .fillMaxWidth()
    ) {
        Row(
            Modifier
                .height(48.dp)
        ) {
            if (onBackClick != null) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back_outlined),
                    contentDescription = "返回",
                    Modifier
                        .clickable(onClick = onBackClick)
                        .align(Alignment.CenterVertically)
                        .size(36.dp)
                        .padding(8.dp),
                    tint = WeComposeTheme.colors.icon
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            //
            val viewModel: WeViewModel = viewModel()
            Icon(
                painter = painterResource(id = R.drawable.ic_palette_outlined),
                contentDescription = "切換主題",
                Modifier
                    .clickable {
                        viewModel.theme = when (viewModel.theme) {
                            WeComposeTheme.Theme.Light -> WeComposeTheme.Theme.Dark
                            WeComposeTheme.Theme.Dark -> WeComposeTheme.Theme.NewYear
                            WeComposeTheme.Theme.NewYear -> WeComposeTheme.Theme.Light
                        }
                    }
                    .align(Alignment.CenterVertically)
                    .size(36.dp)
                    .padding(8.dp),
                tint = WeComposeTheme.colors.icon
            )
        }
        Text(title, Modifier.align(Alignment.Center), color = WeComposeTheme.colors.textPrimary)
    }
}

@Preview(showBackground = true)
@Composable
fun WeTopBarPreview() {
    WeComposeTheme(WeComposeTheme.Theme.Light) {
        WeTopBar("偽信")
    }
}

@Preview(showBackground = true)
@Composable
fun WeTopBarPreviewDark() {
    WeComposeTheme(WeComposeTheme.Theme.Dark) {
        WeTopBar("偽信")
    }
}

@Preview(showBackground = true)
@Composable
fun WeTopBarPreviewNewYear() {
    WeComposeTheme(WeComposeTheme.Theme.NewYear) {
        WeTopBar("偽信")
    }
}