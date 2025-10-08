package com.example.myapplicationtest1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplicationtest1.ui.theme.Darkgreen

@Composable
fun Orderlogo(){
    Image(
        painter = painterResource(id = R.drawable.order),
        contentDescription = "Logo Order",
        modifier = Modifier.width(30.dp).height(30.dp),
        contentScale = ContentScale.FillWidth
    )
}
@Composable
fun Homelogo(){
    Image(
        painter = painterResource(id = R.drawable.home),
        contentDescription = "Logo Order",
        modifier = Modifier.width(30.dp).height(30.dp),
        contentScale = ContentScale.FillWidth
    )
}
@Composable
fun Historylogo(){
    Image(
        painter = painterResource(id = R.drawable.history),
        contentDescription = "Logo Order",
        modifier = Modifier.width(30.dp).height(30.dp),
        contentScale = ContentScale.FillWidth
    )
}
@Composable
fun Accountlogo(){
    Image(
        painter = painterResource(id = R.drawable.account),
        contentDescription = "Logo Order",
        modifier = Modifier.width(30.dp).height(30.dp),
        contentScale = ContentScale.FillWidth
    )
}

@Composable
fun BotNavbar(navController: NavController?){
    Row (
        modifier = Modifier.fillMaxWidth().background(Darkgreen) .wrapContentHeight(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Darkgreen)
            ) {
                Column {
                    Orderlogo()
                    Text("Order")
                }
                }

        }
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {navController?.navigate("homepage")},
                colors = ButtonDefaults.buttonColors(containerColor = Darkgreen)
            ) {
                Column {
                    Homelogo()
                    Text("Home")
                }}
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Darkgreen)
            ) {
                Column {
                    Historylogo()
                    Text("History")
                }
            }

        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Darkgreen)
            ) {
                Column {
                    Accountlogo()
                    Text("Account")
                }
            }

        }
    }
}

@Preview
@Composable
fun ShowBot(){
    val navController = rememberNavController()
    BotNavbar(navController)
}