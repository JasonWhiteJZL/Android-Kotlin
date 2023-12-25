package com.jw.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.jw.myapplication.method.Login
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
    val openDialog = remember { mutableStateOf(true) }
    var login : Login = Login()
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

                      }

        },
            )
        {
            
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    JwmusicTheme {
        Login()
    }
}