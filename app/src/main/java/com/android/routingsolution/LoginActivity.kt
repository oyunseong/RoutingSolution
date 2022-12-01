package com.android.routingsolution

import android.os.Bundle
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.routingsolution.ui.theme.RoutingSolutionTheme

class LoginActivity : ComponentActivity() {
    val title = "HTNS 공동운송"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoutingSolutionTheme {
                LoginScreen()
            }
        }
    }
}


@Preview
@Composable
fun LoginScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        Column() {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.padding(0.dp, 100.dp, 0.dp, 50.dp)
            ) {
                LoginTitleText(name = "HTNS 공동운송")
            }
            Box(modifier = Modifier.padding(10.dp, 0.dp)) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextFieldWithIcons("아이디를 입력해 주세요")
                    TextFieldWithIcons("비밀번호를 입력해 주세요")
                    LoginButton()
                    Box(contentAlignment = Alignment.TopEnd) {
                        SearchInformation()
                    }
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "로그인 / 신규 가입 문의 : 1588-0000")
            }
        }
    }
}


@Composable
fun TextFieldWithIcons(hint: String) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    return OutlinedTextField(
        value = text,
//        leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "emailIcon") },  // 좌측아이콘
        //trailingIcon = { Icon(imageVector = Icons.Default.Add, contentDescription = null) },
        onValueChange = {
            text = it
        },
        label = { Text(text = hint) },
        placeholder = { Text(text = "Enter your id") },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun LoginButton() {
    Button(
        onClick = {},
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "로그인")
    }
}

@Composable
fun LoginTitleText(name: String) {
    Text(
        text = name,
        style = TextStyle(
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )
    )
}

@Composable
fun SearchInformation() {
    ClickableText(text = "아이디 / 비밀번호 찾기", onClick = {})
}

@Composable
fun ClickableText(text: String, onClick: () -> Unit) {
    var enabled by rememberSaveable { mutableStateOf(true) }
    Text(
        modifier = Modifier
            .clickable(enabled = enabled) {
                enabled = false
                onClick()
            },
        text = text
    )
}

@Composable
fun
