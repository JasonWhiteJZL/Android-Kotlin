
package com.jw.myapplication

import android.content.Intent
import android.os.Bundle
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jw.myapplication.ui.theme.JwmusicTheme


class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JwmusicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation()
                }
            }
        }
    }
}

@Composable
fun Navigation()
{
    //TODO:从Splash跳转到Main,Jetpack Compose => Activity
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Splash")
    {
        composable("Splash"){ SplashScreen(navController)}
    }

}
@Composable
fun SplashScreen(navController: NavHostController)
{
    val context = LocalContext.current
    //TODO:Splash View,需在这个Compose里做跳转操作，跳转到Main界面里
    Image(painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = null,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(16.dp)
        )
    val intent = Intent(context,LoginActivity::class.java)
    context.startActivity(intent)

}
@Preview(showBackground = true)
@Composable
fun SplashScreenPreview()
{
    val navController = rememberNavController()
    JwmusicTheme {
        SplashScreen(navController = navController)
    }
}

