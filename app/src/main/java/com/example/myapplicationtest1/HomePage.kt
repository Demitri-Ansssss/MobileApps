package com.example.myapplicationtest1

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationtest1.ui.theme.Darkgreen

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
fun LogoAchieve() {
    Image(
        painter = painterResource(id = R.drawable.achieve),
        contentDescription = "Logo Achieve",
        modifier = Modifier.width(40.dp).height(40.dp),
        contentScale = ContentScale.FillHeight

    )
}
@Composable
fun LogoNotify() {
    Image(
        painter = painterResource(id = R.drawable.notif),
        contentDescription = "Logo Notify",
        modifier = Modifier.width(40.dp).height(40.dp),
        contentScale = ContentScale.FillHeight
    )
}
@Composable
fun Logotrash(){
    Image(
        painter = painterResource(id = R.drawable.trash),
        contentDescription = "Logo trash",
        modifier = Modifier.width(120.dp).height(120.dp),
        contentScale = ContentScale.FillHeight
    )
}

@Composable
fun HomePage(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        Row (
            modifier = Modifier.fillMaxWidth().padding(0.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ){
            LogoHome()
            Text("Clear GO", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.width(130.dp))
            Row {
                LogoAchieve()
                LogoNotify()
            }
        }
        Card (
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    BorderStroke(1.dp, Color.Black),
                    shape = RoundedCornerShape(10.dp)
                ),
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(Color(0xFFf5f5f5)),
            elevation = CardDefaults.cardElevation(10.dp)
        ){
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row {
                    Column (
                        Modifier.padding(top = 20.dp),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text("Pilih & Pilah", fontSize = 33.sp, fontWeight = FontWeight.Bold)
                        Text("Ayo buang sampah", fontSize = 17.sp, fontWeight = FontWeight.Medium)
                    }
                    Spacer(Modifier.width(45.dp))
                    Logotrash()
                }
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = Darkgreen),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.fillMaxWidth().height(50.dp)
                ) {
                    Text("PANGGIL PETUGAS", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                }
            }
        }
        Row {
            
        }
    }
}