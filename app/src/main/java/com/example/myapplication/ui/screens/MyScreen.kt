package com.example.myapplication.ui.screens

import android.media.Image
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import androidx.core.graphics.drawable.toDrawable
import com.example.myapplication.data.MyRecentDataList
import com.example.myapplication.data.WebToonData

@ExperimentalFoundationApi
@Composable
fun MyScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "마이페이지") },
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
        MyTabRow()
    }
}

@ExperimentalFoundationApi
@Composable
fun MyTabRow() {
    var state by remember { mutableStateOf(0) }
    val titles = listOf("최근 본", "좋아요", "구매목록", "다운로드")
    Column {
        TabRow(selectedTabIndex = state, divider = { Divider() }, backgroundColor = Color.White) {
            titles.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title) },
                    selected = state == index,
                    onClick = { state = index },
                )
            }
        }
        MyContent(state = state)
    }
}

@ExperimentalFoundationApi
@Composable
fun MyContent(
    state: Int
){
    when (state) {
        0 -> {
            ThreeWebToonGrid(items = MyRecentDataList)
        }
        1 -> {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = "좋아요")
            }
        }
        2 -> {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = "구매목록")
            }
        }
        3 -> {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = "다운로드")
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun ThreeWebToonGrid(
    items: List<WebToonData>
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        content = {
            items(items) { item ->
                Image(
                    painter = painterResource(item.drawable),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(3.dp)
                        .aspectRatio(1f) // 이거로도 안됨..
                )
            }
        }
    )
}

@Composable
fun WebToon(
    modifier: Modifier = Modifier,
    items: List<WebToonData>,
    width: Int,
    height: Int
) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        items(items) { item ->
            Image(
                painter = painterResource(item.drawable),
                contentDescription = null, // ?
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .width(width.dp)
                    .height(height.dp)
            )
        }
    }
}