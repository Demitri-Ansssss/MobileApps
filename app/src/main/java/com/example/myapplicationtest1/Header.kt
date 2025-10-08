package com.example.myapplicationtest1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LogoAchieve() {
    Image(
        painter = painterResource(id = R.drawable.achieve),
        contentDescription = "Logo Achieve",
        modifier = Modifier
            .width(40.dp)
            .height(40.dp),
        contentScale = ContentScale.FillHeight

    )
}
@Composable
fun LogoNotify() {
    Image(
        painter = painterResource(id = R.drawable.notif),
        contentDescription = "Logo Notify",
        modifier = Modifier
            .width(40.dp)
            .height(40.dp),
        contentScale = ContentScale.FillHeight
    )
}

@Composable
fun LogoHome() {
    Image(
        painter = painterResource(id = R.drawable.logo),
        contentDescription = "Logo Apps",
        modifier = Modifier
            .width(80.dp)
            .height(80.dp)
            .clip(CircleShape),
        contentScale = ContentScale.FillHeight
    )
}
@Composable
fun Header(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ) {
        LogoHome()
        Text("Clear GO", fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.width(130.dp))
        Row {
            LogoAchieve()
            LogoNotify()
        }
    }
}

@Preview
@Composable
fun showheader(){
    Header()
}