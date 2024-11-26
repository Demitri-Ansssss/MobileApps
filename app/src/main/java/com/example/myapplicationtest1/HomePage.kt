package com.example.myapplicationtest1

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myapplicationtest1.ui.theme.Darkgreen
import com.example.myapplicationtest1.ui.theme.Lightgreen



@Composable
fun ImgSampah(){
    Image(
        painter = painterResource(id = R.drawable.carausel),
        contentDescription = "Logo trash",
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        contentScale = ContentScale.FillWidth
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
fun Logotrash(){
    Image(
        painter = painterResource(id = R.drawable.trash),
        contentDescription = "Logo trash",
        modifier = Modifier
            .width(120.dp)
            .height(120.dp),
        contentScale = ContentScale.FillHeight
    )
}

@Composable
fun Kointrash(){
    Image(
        painter = painterResource(id = R.drawable.koin),
        contentDescription = "koin trash",
        modifier = Modifier
            .width(30.dp)
            .height(30.dp),
        contentScale = ContentScale.FillHeight
    )
}

@Composable
fun BuangSampah() {
    Image(
        painter = painterResource(id = R.drawable.buangsampah),
        contentDescription = "buang sampah",
        modifier = Modifier
            .size(210.dp)
            .absoluteOffset(x = 8.dp, y = -25.dp)
            .zIndex(1f), // Menggunakan size untuk ukuran yang sama
        contentScale = ContentScale.FillHeight
    )
}

@Composable
fun HomePage(navController: NavHostController) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .fillMaxWidth()
            .background(color = Color.White)
//            .padding(10.dp),
    )
    {
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
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)

                .border(
                    BorderStroke(1.dp, Color.Black),
                    shape = RoundedCornerShape(10.dp),
                    
                ),
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(Color(0xFFf5f5f5)),
            elevation = CardDefaults.cardElevation(10.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row {
                    Column(
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
                    onClick = {navController.navigate("Menu")},
                    colors = ButtonDefaults.buttonColors(containerColor = Darkgreen),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(
                        "PANGGIL PETUGAS",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }

            }
        }
//
        Spacer(modifier = Modifier.height(15.dp))
//        Button Payment dan Points
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(Lightgreen),

                )
            {
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(20.dp)

                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .background(Color(0xFF4CAF50), shape = CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Rp",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "DANA",
                            color = Color(0xFF4CAF50),
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = ">",
                            color = Color(0xFF4CAF50),
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier.padding(10.dp)
                    ) {
                        Text(
                            text = "O",
                            color = Color(0xFF4CAF50),
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 7.dp)
                        )
                        Spacer(modifier = Modifier.width(27.dp))
                        Text(
                            text = "Rupiah",
                            color = Color(0xFF4CAF50),
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Normal
                        )
                    }
                }

            }
//            Button Points
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(Darkgreen),

                )
            {
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(20.dp),

                    ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .background(color = Color.White, shape = CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Kointrash()
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "Points",
                            color = Color.White,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier.padding(10.dp)
                    ) {
                        Text(
                            text = "O",
                            color = Color.White,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.padding(start = 7.dp)
                        )
                        Spacer(modifier = Modifier.width(27.dp))
                        Text(
                            text = "Points",
                            color = Color.White,
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Normal
                        )
                    }
                }
            }
        }

//        Rekomendasi
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(start = 8.dp, end = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Rekomendasi Untukmu",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = "Selengkapnya",
                    color = Color.Green,
                    fontSize = 14.sp
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF00C853), shape = RoundedCornerShape(8.dp))
                    .padding(top = 10.dp, start = 10.dp)
            ) {
                Row(
                    modifier = Modifier.padding(0.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.Start,
                    ) {
                        Text(
                            text = "Hadiah dari Clear GO",
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                        Row {
                            Column {
                                Text(
                                    "Untuk Pelanggan", fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    textAlign = TextAlign.Center
                                )
                                Text(
                                    "Setia", fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    textAlign = TextAlign.Center
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                Text(
                                    text = "RP 2500 Point",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFFFFEB3B)
                                )

                                Spacer(modifier = Modifier.height(4.dp))

                                Text(
                                    text = "Untuk Mendapatkan Gratis",
                                    fontSize = 15.sp,
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "Ongkir",
                                    fontSize = 15.sp,
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )
                                Button(
                                    onClick = { /* Action on click */ },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color.White
                                    ),
                                    modifier = Modifier
                                        .width(130.dp)
                                        .absoluteOffset(x = 50.dp),
                                    shape = RoundedCornerShape(10.dp)
                                ) {
                                    Text(
                                        text = "TUKARKAN",
                                        color = Color.Black,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 15.sp
                                    )
                                }
                            }
                            BuangSampah()
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))

            Column (
                modifier = Modifier.fillMaxHeight().fillMaxWidth()
            ) {
                ImgSampah()
            }
        }
        BotNavbar()
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewHomepage(){
    val navController = rememberNavController()
    HomePage(navController)
}


