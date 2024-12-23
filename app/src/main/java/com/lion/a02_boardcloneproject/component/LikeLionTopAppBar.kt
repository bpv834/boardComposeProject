package com.lion.a02_boardcloneproject.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LikeLionTopAppBar(title:String = ""){
    TopAppBar(
        // 타이틀
        title = {
            Text(text = title)
        }
    )
}