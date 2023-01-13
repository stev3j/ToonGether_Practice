package com.example.myapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.data.*

@Composable
fun HomeScreen() {
    Column {
        Image(
            painter = painterResource(id = R.drawable.firechicken),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(393.dp)
        )
        Text(
            text = "최근 본 웹툰 이어보기",
            modifier = Modifier.padding(top = 10.dp, start = 16.dp)
        )
        WebToonGrid(
            modifier = Modifier.padding(top = 6.dp),
            items = RecentDataList,
            width = 132, height = 82
        )
        Text(
            text = "인기 판타지 웹툰",
            modifier = Modifier.padding(top = 20.dp, start = 16.dp)
        )
        WebToonGrid(
            modifier = Modifier.padding(top = 6.dp),
            items = PopDataList,
            width = 119, height = 165
        )
    }
}

// Card Tab

@Composable
fun WebToonGrid(
    modifier: Modifier = Modifier,
    items: List<WebToonData>,
    width: Int,
    height: Int
) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items) { item ->
            Image(
                painter = painterResource(item.drawable),
                contentDescription = null, // ?
                contentScale = ContentScale.Fit,
                modifier = Modifier.width(width.dp).height(height.dp)
            )
        }
    }
}