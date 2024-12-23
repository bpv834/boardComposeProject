package com.lion.a02_boardcloneproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lion.a02_boardcloneproject.screen.UserLoginScreen
import com.lion.a02_boardcloneproject.ui.theme._02_BoardCloneProjectTheme
import com.lion.a02_boardcloneproject.util.MainScreenName
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        enableEdgeToEdge()
        setContent {
            _02_BoardCloneProjectTheme {
                BoardMain()

            }
        }
    }
}

@Composable
fun BoardMain() {
    // 네비게이션 객체
    val navHostController = rememberNavController()
    // Application 객체에 담는다.
    val boardApplication = LocalContext.current.applicationContext as BoardApplication
    boardApplication.navHostController = navHostController

    NavHost(
        // 화면 전환을 관리할 네비게이션 객체
        navController = navHostController,
        // 처음 보여질 화면 요소의 이름을 설정한다.
        startDestination =MainScreenName.MAIN_SCREEN_USER_LOGIN.name,

        // 화면전환 애니메이션
        // NavHost에 지정하면 모든 화면에 대한 기본 애니메이션을 설정한다.
        // 각 화면별로 설정하는 것도 가능하다.
        // A 에서 B 갈때
        // EnterTransition : B 가 나타날때의 애니메이션
        // ExitTransition : A 가 사라질때의 애니메이션
        // B 에서 A 로 돌아갈때
        // PopEnterTransition : A가 다시 나타날 때의 애니메이션
        // PopExitTransition : B가 사라질 때의 애니메이션
        // https://developer.android.com/develop/ui/compose/animation/composables-modifiers?hl=ko
        enterTransition = {
            fadeIn(
                tween(300)
            ) +
                    slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Start,
                        tween(300)
                    )
        },
        popExitTransition = {
            fadeOut(
                tween(300)
            ) +
                    slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.End,
                        tween(300)
                    )
        },
        exitTransition = {
            fadeOut(
                tween(300)
            )
        },
        popEnterTransition = {
            fadeIn(
                tween(300)
            )
        },
    ){
        // 로그인 화면
        composable(
            route = MainScreenName.MAIN_SCREEN_USER_LOGIN.name
        ){
            UserLoginScreen()
        }

    }
}