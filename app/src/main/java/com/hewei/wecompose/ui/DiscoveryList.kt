package com.hewei.wecompose.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hewei.wecompose.R
import com.hewei.wecompose.ui.theme.WeComposeTheme


@Composable
fun DiscoveryListTopBar() {
    WeTopBar(title = "發現")
}

@Composable
fun DiscoveryList() {
    Column(
        Modifier
            .fillMaxSize()
    ) {
        DiscoveryListTopBar()
        Box(
            Modifier
                .background(WeComposeTheme.colors.background)
                .fillMaxSize()
        ) {
            Column(
                Modifier
                    .background(WeComposeTheme.colors.listItem)
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
            ) {
                DiscoveryListItem(
                    icon = R.drawable.ic_moments,
                    title = "朋友圈",
                    badge = {
                        Box(
                            Modifier
                                .padding(8.dp)
                                .clip(RoundedCornerShape(50))
                                .size(18.dp)
                                .background(WeComposeTheme.colors.badge)
                        ) {
                            Text(
                                "3",
                                Modifier.align(Alignment.Center),
                                fontSize = 12.sp,
                                color = WeComposeTheme.colors.onBadge
                            )
                        }
                    },
                    endBadge = {
                        Image(
                            painterResource(R.drawable.avatar_he_wei), "avatar", Modifier
                                .padding(8.dp, 0.dp)
                                .size(32.dp)
                                .unread(false, WeComposeTheme.colors.badge)
                                .clip(RoundedCornerShape(4.dp))
                        )
                    }
                )
                Spacer(
                    modifier = Modifier
                        .background(WeComposeTheme.colors.background)
                        .fillMaxWidth()
                        .height(8.dp)
                )
                DiscoveryListItem(
                    icon = R.drawable.ic_channels,
                    title = "視頻號",
                    endBadge = {
                        Image(
                            painterResource(R.drawable.avatar_danial_han), "avatar", Modifier
                                .padding(8.dp, 0.dp)
                                .size(32.dp)
                                .unread(false, WeComposeTheme.colors.badge)
                                .clip(RoundedCornerShape(4.dp))
                        )
                        Text(
                            "讚過", Modifier.padding(0.dp, 0.dp, 4.dp, 0.dp),
                            fontSize = 14.sp, color = WeComposeTheme.colors.textSecondary
                        )
                    }
                )
                Spacer(
                    modifier = Modifier
                        .background(WeComposeTheme.colors.background)
                        .fillMaxWidth()
                        .height(8.dp)
                )
                DiscoveryListItem(
                    icon = R.drawable.ic_ilook,
                    title = "看一看"
                )
                Spacer(
                    modifier = Modifier
                        .background(WeComposeTheme.colors.background)
                        .fillMaxWidth()
                        .height(8.dp)
                )
                DiscoveryListItem(
                    icon = R.drawable.ic_isearch,
                    title = "搜一搜"
                )
                Spacer(
                    modifier = Modifier
                        .background(WeComposeTheme.colors.background)
                        .fillMaxWidth()
                        .height(8.dp)
                )
                DiscoveryListItem(
                    icon = R.drawable.ic_nearby,
                    title = "直播和附近"
                )
            }
        }
    }
}

@Composable
fun DiscoveryListItem(
    @DrawableRes icon: Int,
    title: String,
    badge: @Composable (() -> Unit)? = null,
    endBadge: @Composable (() -> Unit)? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painterResource(icon), "title", Modifier
                .padding(12.dp, 8.dp, 8.dp, 8.dp)
                .size(36.dp)
                .padding(8.dp)
        )
        Text(
            title,
            fontSize = 17.sp,
            color = WeComposeTheme.colors.textPrimary
        )
        badge?.invoke()
        Spacer(Modifier.weight(1f))
        endBadge?.invoke()
        Icon(
            painter = painterResource(R.drawable.ic_arrow_outlined),
            contentDescription = "更多",
            modifier = Modifier
                .padding(0.dp, 0.dp, 12.dp, 0.dp)
                .size(24.dp),
            tint = WeComposeTheme.colors.more
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DiscoveryListPreviewNewYear() {
    WeComposeTheme(WeComposeTheme.Theme.NewYear) {
        DiscoveryList()
    }
}