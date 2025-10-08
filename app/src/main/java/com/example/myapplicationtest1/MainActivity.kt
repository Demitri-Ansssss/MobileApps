package com.example.myapplicationtest1
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import kotlinx.coroutines.delay
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent() {
            MainDisplay()
        }
    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun MainDisplay(){
        val navController = rememberNavController()
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    val pagesWithBottomNav = listOf("HomePage", "Menu", "Detail Pembayaran","detail page/{iconId}/{name}/{totalCount}")
        Scaffold (
            topBar = {if (currentRoute == "HomePage"){
                Header()
            } },
        bottomBar = { if (currentRoute in pagesWithBottomNav) {
            BotNavbar(navController)
        } }
    ){ PaddingValues ->
            Box(
                modifier = Modifier
                    .padding(PaddingValues)
                    .fillMaxSize()
            ) {
                NavHost(
                    navController = navController,
                    startDestination = "LoadingPage"
                ) {
                    composable("LoadingPage") {
                        LoadingScreen(navController = navController, nextDestination = "LoginPage")
                    }
                    composable("LoginPage"){LoginPage(navController)}
                    composable("RegisterPage") { RegisterPage(navController) }
                    composable("HomePage") { HomePage(navController) }
                    composable("Deteksi"){Detection(navController)}
                    composable("Menu"){MenuSampah(navController)}
                    composable("Detail Pembayaran"){DetailPembayaran(navController)}
                    composable(
                        "detail page/{iconId}/{name}/{totalCount}",
                        arguments = listOf(
                            navArgument("iconId") { type = NavType.IntType },
                            navArgument("name") { type = NavType.StringType },
                            navArgument("totalCount") { type = NavType.IntType }
                        )
                    ) { backStackEntry ->
                        val iconId = backStackEntry.arguments?.getInt("iconId")
                        val name = backStackEntry.arguments?.getString("name")
                        val totalCount = backStackEntry.arguments?.getInt("totalCount")
                        val listMapsViewModel: ListMaps = viewModel()
                        DetailPage(iconId = iconId, name = name,navController = navController , viewModel = listMapsViewModel)
                    }
                }
            }
    }
}

@Composable
fun LoadingScreen(navController: NavController, nextDestination: String) {
    var isLoading by remember { mutableStateOf(true) }

    // Simulasi loading dengan delay
    LaunchedEffect(Unit) {
        delay(3000) // Simulasi loading selama 2 detik
        isLoading = false
        navController.navigate(nextDestination) {
            popUpTo("LoadingPage") { inclusive = true }
        }
    }

    // Tampilan loading
    if (isLoading) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.logo),
                    contentDescription = "Loading Logo",
                    modifier = Modifier
                        .width(200.dp)
                        .height(200.dp),
                    contentScale = ContentScale.FillWidth
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Loading...", style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}