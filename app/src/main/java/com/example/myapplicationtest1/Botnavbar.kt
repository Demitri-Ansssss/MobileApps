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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
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
fun BotNavbar(){
    Row (
        modifier = Modifier.fillMaxWidth().background(Darkgreen).padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Orderlogo()
            Text("Order")
        }
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Homelogo()
            Text("Home")
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Historylogo()
            Text("History")
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Accountlogo()
            Text("Account")
        }
    }
}