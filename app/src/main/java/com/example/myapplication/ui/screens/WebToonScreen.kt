package com.example.myapplication.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

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
        ScrollableTabRow(selectedTabIndex = state, divider = { Divider() }, backgroundColor = Color.White) {
            titles.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title) },
                    selected = state == index,
                    onClick = { state = index },
                )
            }
        }
    }
}
