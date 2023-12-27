package com.jw.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.jw.myapplication.method.LoginMethod
import com.jw.myapplication.ui.theme.JwmusicTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JwmusicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                  Login()
                }
            }
        }
    }
}

@Composable
fun Login()
{
    val context = LocalContext.current
    var account by remember { mutableStateOf("") }
    var pwd by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }
    var login : LoginMethod = LoginMethod()

    if (showDialog) {
        AlertDialog(
            onDismissRequest = {
                // 关闭对话框
                showDialog = false
            },
            title = {
                Text("AlertDialog Title")
            },
            text = {
                Text("Your entered account or password is error,please try again! ")
            },
            confirmButton = {
                Button(onClick = {
                    // 处理确认按钮点击事件
                    showDialog = false
                }) {
                    Text("OK")
                }
            },
            dismissButton = {
                // 可选的取消按钮
                Button(onClick = {
                    // 处理取消按钮点击事件
                    showDialog = false
                }) {
                    Text("Cancel")
                }
            }
        )
    }
    Column()
    {
        TextField(
            value = account,
            onValueChange = {account = it},
            label = {Text("Account")}
        )

        TextField(
            value = pwd,
            onValueChange = {pwd = it},
            label = {Text("PassWord")}
        )

        Button(
            onClick = {
                      if(login.login(account,pwd))
                      {
                          val intent = Intent(context,MainActivity::class.java)
                          context.startActivity(intent)
                      }else{
                          //TODO 这里使用Compose的消息弹窗
                          showDialog = true
                      }
        },
            )
        {
            Text("Button")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    JwmusicTheme {
        Login()
    }
}