package com.example.myapplicationtest1

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun DetailPembayaran(navController: NavController) {
val viewModel: ListMaps = viewModel()
    var KodePromo by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .clickable {
                    navController.popBackStack()
                },
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "<",
                textAlign = TextAlign.Start,
                color = Color.Black,
                fontSize = 30.sp,
                modifier = Modifier.padding(5.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text("Detail Pembayaran", color = Color.Black, fontSize = 20.sp)
        }


        Column (
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.Center
        ){
            Text(
                "Penjemputan Sampah", modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 10.dp),
                fontSize = 20.sp, fontWeight = FontWeight.Bold
            )
            Row (
                modifier = Modifier.padding(10.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.pinmaps),
                    contentDescription = "Pin Maps",
                    modifier = Modifier
                        .width(20.dp)
                        .height(20.dp)
                        .clip(RectangleShape),
                    contentScale = ContentScale.FillHeight
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    // Tampilkan lokasi yang dipilih
                    Text("${locationText}", fontWeight = FontWeight.SemiBold, fontSize = 15.sp)
                }
            }
            Row(
                modifier = Modifier.padding(10.dp)
            ) {

                Image(
                    painter = painterResource(R.drawable.date_range),
                    contentDescription = "Date Range",
                    modifier = Modifier.width(20.dp)
                    .height(20.dp)
                    .clip(RectangleShape),
                    contentScale = ContentScale.FillHeight
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text("Senin, 09.00 - 10.00 WIB", fontWeight = FontWeight.SemiBold, fontSize = 15.sp)
                }
            }
            Spacer(modifier = Modifier.height(50.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 10.dp, end = 10.dp)
            ) {
                Text("Total : ", fontSize = 15.sp, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.width(210.dp))
                Text("Rp. 33.000",fontSize = 15.sp, fontWeight = FontWeight.SemiBold)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text("Pembayaran",fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("pembayaran melalui:",fontSize = 15.sp, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.width(160.dp))
                Text("${Pembayaran}",fontSize = 15.sp, fontWeight = FontWeight.SemiBold)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text("Kode Promo",fontSize = 20.sp, fontWeight = FontWeight.Bold)
            CustomTextField(
                label = "Kode Promo",
                stateText = KodePromo,
                onChange = {KodePromo = it },
            )
        }
    }
}


@Preview
@Composable
fun  ShowDetail(){
    val navController = rememberNavController()
    DetailPembayaran(navController)
}