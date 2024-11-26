package com.example.myapplicationtest1
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent() {
            MainDisplay()
        }
    }
}

@Composable
fun MainDisplay(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "LoginPage"
    ) {
        composable("LoginPage"){LoginPage(navController)}
        composable("RegisterPage") { RegisterPage(navController) }
        composable("HomePage") { HomePage(navController) }
        composable("Menu"){MenuSampah(navController)}
    }
}

