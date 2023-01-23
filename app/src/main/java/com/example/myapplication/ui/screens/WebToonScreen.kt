@file:OptIn(ExperimentalSnapperApi::class)

package com.example.myapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.data.PopDataList
import com.example.myapplication.data.TitleList
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import dev.chrisbanes.snapper.rememberSnapperFlingBehavior

@Composable
fun WebToonScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "웹툰") },
                backgroundColor = Color.White,
                elevation = 0.dp,
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Search",
                            tint = Color.Black
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Menu",
                            tint = Color.Black
                        )
                    }
                }
            )
        },
    ) {
        TabRowWebtoon()
    }
}

@Composable
fun TabRowWebtoon() {
    var state by remember { mutableStateOf(0) }
    val titles = listOf("홈", "요일", "판타지", "드라마", "로맨스", "BL", "액션")
    Column {
        ScrollableTabRow(
            selectedTabIndex = state,
            divider = { Divider() },
            backgroundColor = Color.White,
            edgePadding = 0.dp,
            indicator = { tabPositions ->
                Box(
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[state])
                        .height(2.dp)
                        .padding(horizontal = 32.dp)
                        .background(color = Color.Black)
                )
            },
        ) {
            titles.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title) },
                    selected = state == index,
                    onClick = { state = index },
                )
            }
        }
        WebtoonContent(state = state)
    }
}

@Composable
fun WebtoonContent(
    state: Int
){
    when (state) {
        0 -> {
            Webtoon_Home()
        }
        1 -> {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = "Week")
            }
        }
        2 -> {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = "fantasy")
            }
        }
        3 -> {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = "drama")
            }
        }
        4 -> {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = "romans")
            }
        }
        5 -> {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = "bl")
            }
        }
        6 -> {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = "action")
            }
        }
    }
}

@Composable
fun Webtoon_Home() {
    Column() {
        HomeTitleScreen()
        Text(
            text = "인기 판타지 웹툰",
            modifier = Modifier.padding(top = 20.dp, start = 16.dp)
        )
        WebToonGrid(
            modifier = Modifier.padding(top = 6.dp),
            items = PopDataList,
            width = 119, height = 165
        )
        Text(
            text = "HOT! 신작",
            modifier = Modifier.padding(top = 20.dp, start = 16.dp)
        )
        WebToonGrid(
            modifier = Modifier.padding(top = 6.dp),
            items = PopDataList,
            width = 119, height = 165
        )
    }
}

@Composable
fun HomeTitleScreen() {
    val lazyListState: LazyListState = rememberLazyListState()

    LazyRow(
        state = lazyListState,
        flingBehavior = rememberSnapperFlingBehavior(lazyListState),
    ) {
        items(TitleList) { item ->
            Image(
                painter = painterResource(item.drawable),
                contentDescription = null,
                modifier = Modifier
                    .width(393.dp)
                    .height(302.dp)
            )
        }
    }
}