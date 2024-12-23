package com.lion.a02_boardcloneproject.component

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun LikeLionOutlinedTextField(
    // 입력값에 대한 상태관리 변수
    textFieldValue: MutableState<String> = mutableStateOf(""),
    // hint
    label: String = "",
    // 포커스가 주어지고 입력된 내용이 없을 경우 보여줄 안내 문구
    placeHolder: String = "",
    // 정규식
    inputCondition: String? = null,
    // 입력 요소 앞의 아이콘
    leadingIcon: @Composable (() -> Unit)? = null,
    // 우측 끝의 아이콘
    trailingIconMode:LikeLionOutlinedTextFieldEndIconMode,
    // 한줄 입력 여부
    singleLine:Boolean = false,
    // TextField를 위한 ViewModel
    likeLionOutlinedTextFieldViewModel: LikeLionOutlinedTextFieldViewModel = hiltViewModel(),
    // 상단 여백
    paddingTop: Dp =0.dp,
    // 입력 모드
    inputType:LikeLionOutlinedTextFieldInputType = LikeLionOutlinedTextFieldInputType.TEXT,
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth().padding(top = paddingTop),
        value = textFieldValue.value,
        label = {
            Text(text = label)
        },
        placeholder = {
            Text(text = placeHolder)
        },
        onValueChange = {
            if (inputCondition == null) {
                textFieldValue.value = it
            } else {
                textFieldValue.value = it.replace(inputCondition.toRegex(), "")
            }
        },
        leadingIcon = leadingIcon,
        trailingIcon = {
            SettingLikeLionOutlinedTextFieldTrailingIcon(
                textFieldValue,
                trailingIconMode
            )
        },
        singleLine = singleLine,
        visualTransformation =  if(likeLionOutlinedTextFieldViewModel.passwordShowingFlag.value == false && inputType == LikeLionOutlinedTextFieldInputType.PASSWORD){
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        }
    )
}

@Composable
fun SettingLikeLionOutlinedTextFieldTrailingIcon(
    textFieldValue: MutableState<String> = mutableStateOf(""),
    trailingIconMode:LikeLionOutlinedTextFieldEndIconMode,
    likeLionOutlinedTextFieldViewModel: LikeLionOutlinedTextFieldViewModel = hiltViewModel()
) {
    // 비밀번호가 보이는지...
    var isShowingPasswordFlag by rememberSaveable {
        mutableStateOf(false)
    }
    // trailingIcon
    when(trailingIconMode){
        LikeLionOutlinedTextFieldEndIconMode.NONE -> null
        LikeLionOutlinedTextFieldEndIconMode.TEXT -> {
            if(textFieldValue.value.isNotEmpty()){
                IconButton(
                    onClick = {
                        textFieldValue.value = ""
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Clear,
                        contentDescription = null
                    )
                }
            } else {

            }
        }
        LikeLionOutlinedTextFieldEndIconMode.PASSWORD -> {
            IconButton(
                onClick = {
                    likeLionOutlinedTextFieldViewModel.passwordShowingFlag.value = !likeLionOutlinedTextFieldViewModel.passwordShowingFlag.value
                }
            ) {
                if(likeLionOutlinedTextFieldViewModel.passwordShowingFlag.value){
                    Icon(Icons.Filled.Visibility, contentDescription = null)
                } else {
                    Icon(Icons.Filled.VisibilityOff, contentDescription = null)
                }
            }
        }
    }
}

enum class LikeLionOutlinedTextFieldInputType{
    TEXT,
    PASSWORD,
    NUMBER,
}

enum class LikeLionOutlinedTextFieldEndIconMode{
    NONE,
    TEXT,
    PASSWORD,
}