package com.lion.a02_boardcloneproject.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.lion.a02_boardcloneproject.R
import com.lion.a02_boardcloneproject.component.LikeLionOutlinedTextField
import com.lion.a02_boardcloneproject.component.LikeLionOutlinedTextFieldEndIconMode
import com.lion.a02_boardcloneproject.component.LikeLionOutlinedTextFieldInputType
import com.lion.a02_boardcloneproject.component.LikeLionTopAppBar
import com.lion.a02_boardcloneproject.viewmodel.UserLoginViewModel

@Composable
fun UserLoginScreen(userLoginViewModel: UserLoginViewModel= hiltViewModel()) {
    Scaffold(
        topBar = {
            LikeLionTopAppBar(title = "로그인")
        }
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(start = 10.dp, end = 10.dp)
        ){
            // 아이디 입력 요소
            LikeLionOutlinedTextField(
                textFieldValue = userLoginViewModel.textFieldUserLoginIdValue,
                label = "아이디",
                placeHolder = "아이디를 입력해주세요",
                inputCondition = "[^a-zA-Z0-9_]",
                trailingIconMode = LikeLionOutlinedTextFieldEndIconMode.TEXT,
                singleLine = true,

            )
            // 비밀번호 입력 요소
            LikeLionOutlinedTextField(
                textFieldValue = userLoginViewModel.textFieldUserLoginPasswordValue,
                label = "비밀번호",
                placeHolder = "비밀번호를 입력해주세요",
                inputCondition = "[^a-zA-Z0-9_]",
                leadingIcon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.key_24px),
                        contentDescription = null
                    )
                },
                trailingIconMode = LikeLionOutlinedTextFieldEndIconMode.PASSWORD,
                singleLine = true,
                paddingTop = 10.dp,
                inputType = LikeLionOutlinedTextFieldInputType.PASSWORD

            )
        }
    }
}

