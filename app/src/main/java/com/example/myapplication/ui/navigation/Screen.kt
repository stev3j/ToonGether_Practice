package com.example.myapplication.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.myapplication.R

sealed class Screen(val title: String, val icon: Int, val screenRoute: String) {
    object Home : Screen("홈", R.drawable.ic_home, HOME)
    object Week : Screen("요일별", R.drawable.ic_week, WEEK)
    object Genre : Screen("장르별", R.drawable.ic_genre, GENRE)
    object Community : Screen("커뮤니티", R.drawable.ic_community, COMMUNITY)
    object My : Screen("MY", R.drawable.ic_my, MY)
}

const val HOME = "HOME"
const val WEEK = "WEEK"
const val GENRE = "GENRE"
const val COMMUNITY = "COMMUNITY"
const val MY = "MY"
