package com.lion.a02_boardcloneproject.component

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LikeLionOutlinedTextFieldViewModel @Inject constructor() : ViewModel() {
    // 비밀번호일 경우 비밀번호가 보이는지 여부를 설정할 상태 관리 변수
    val passwordShowingFlag = mutableStateOf(false)
}