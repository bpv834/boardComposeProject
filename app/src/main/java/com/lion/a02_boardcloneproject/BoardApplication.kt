package com.lion.a02_boardcloneproject

import android.app.Application
import androidx.navigation.NavHostController
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BoardApplication: Application() {
    // 네비게이션
    lateinit var navHostController: NavHostController
}