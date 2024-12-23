package com.lion.a02_boardcloneproject.viewmodel

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.lion.a02_boardcloneproject.BoardApplication
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class UserLoginViewModel @Inject constructor(
    @ApplicationContext context: Context
) : ViewModel() {

    val boardApplication = context as BoardApplication

    // 아이디 입력 요소
    val textFieldUserLoginIdValue = mutableStateOf("")

    // 비밀번호 입력 요소
    val textFieldUserLoginPasswordValue = mutableStateOf("")


}