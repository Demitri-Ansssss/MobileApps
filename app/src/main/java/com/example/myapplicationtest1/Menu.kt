package com.example.myapplicationtest1

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplicationtest1.ui.theme.Darkgreen


@Composable
fun KresekKecil(){
    Image(
        painter = painterResource(id=R.drawable.kresekkecil),
        contentDescription = "Kresek Kecil",
        modifier = Modifier.width(150.dp).height(150.dp),
        contentScale = ContentScale.FillWidth
    )
}
@Composable
fun KresekBesar(){
    Image(
        painter = painterResource(id=R.drawable.kresekhitam),
        contentDescription = "Kresek Kecil",
        modifier = Modifier.width(150.dp).height(150.dp),
        contentScale = ContentScale.FillWidth
    )
}
@Composable
fun KresekSedang(){
    Image(
        painter = painterResource(id=R.drawable.kresekputih),
        contentDescription = "Kresek Kecil",
        modifier = Modifier.width(150.dp).height(150.dp),
        contentScale = ContentScale.FillWidth
    )
}

@Composable
fun CounterComponent() {
    var count by remember { mutableStateOf(0) }

    Row(
        modifier = Modifier
            .padding(0.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        // Minus Button
        IconButton(
            onClick = { if (count > 0) count-- },
            modifier = Modifier.size(30.dp)
        ) {
            Text(
                text = "-",
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier
                    .background(Color.Gray, shape = RoundedCornerShape(4.dp))
                    .fillMaxSize(),
                textAlign = TextAlign.Center
            )
        }

        // Number Display
        Text(
            text = count.toString(),
            fontSize = 20.sp,
            color = Color.Black,
            modifier = Modifier
                .width(50.dp)
                .padding(horizontal = 8.dp),
            textAlign = TextAlign.Center
        )

        // Plus Button
        IconButton(
            onClick = { count++ },
            modifier = Modifier.size(30.dp)
        ) {
            Text(
                text = "+",
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier
                    .background(Color.Gray, shape = RoundedCornerShape(4.dp))
                    .fillMaxSize(),
                textAlign = TextAlign.Center
            )
        }
    }
}



@Composable
fun PilihNavigation() {
    var selectedTabIndex by remember { mutableStateOf(0) }

    val tabs = listOf("Sampah Campur", "Sampah Kering", "Sampah Basah")

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            tabs.forEachIndexed { index, tabName ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .weight(1f)
                        .padding(vertical = 8.dp)
                ) {
                    TextButton(
                        onClick = { selectedTabIndex = index },
                        colors = ButtonDefaults.textButtonColors(
                            contentColor = if (selectedTabIndex == index) Color.Black else Color.Black
                        )
                    ) {
                        Text(text = tabName)
                    }
                    if (selectedTabIndex == index) {
                        Box(
                            modifier = Modifier
                                .height(2.dp)
                                .fillMaxWidth()
                                .background(Color.Green)
                        )
                    }
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp)
        ) {
            Column {
                when (selectedTabIndex) {
                    0 ->Column {
                        Row (
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround,

                            ){
                            KresekBesar()

                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text("Kresek Besar", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                                CounterComponent()
                            }
                            Spacer(Modifier.width(20.dp))
                            Box(
                                modifier = Modifier
                                    .border(width = 2.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp))
                                    .padding(5.dp)
                                    .background(Darkgreen),

                                ) {
                                Text("100 Points", fontSize =15.sp, modifier = Modifier.padding(5.dp),
                                    color = Color.White)
                            }
                        }
                        Row (
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround,

                            ){
                            KresekBesar()

                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text("Kresek Besar", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                                CounterComponent()
                            }
                            Spacer(Modifier.width(20.dp))
                            Box(
                                modifier = Modifier
                                    .border(width = 2.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp))
                                    .padding(5.dp)
                                    .background(Darkgreen),

                                ) {
                                Text("100 Points", fontSize =15.sp, modifier = Modifier.padding(5.dp),
                                    color = Color.White)
                            }
                        }
                        Row (
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround,

                            ){
                            KresekBesar()

                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text("Kresek Besar", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                                CounterComponent()
                            }
                            Spacer(Modifier.width(20.dp))
                            Box(
                                modifier = Modifier
                                    .border(width = 2.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp))
                                    .padding(5.dp)
                                    .background(Darkgreen),

                                ) {
                                Text("100 Points", fontSize =15.sp, modifier = Modifier.padding(5.dp),
                                    color = Color.White)
                            }
                        }

                    }

                        1 ->
                            Column {
                                Row (
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceAround,

                                    ){
                                    KresekBesar()

                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text("Kresek Besar", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                                        CounterComponent()
                                    }
                                    Spacer(Modifier.width(20.dp))
                                    Box(
                                        modifier = Modifier
                                            .border(width = 2.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp))
                                            .padding(5.dp)
                                            .background(Darkgreen),

                                        ) {
                                        Text("100 Points", fontSize =15.sp, modifier = Modifier.padding(5.dp),
                                            color = Color.White)
                                    }
                                }
                                Row (
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceAround,

                                    ){
                                    KresekBesar()

                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text("Kresek Besar", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                                        CounterComponent()
                                    }
                                    Spacer(Modifier.width(20.dp))
                                    Box(
                                        modifier = Modifier
                                            .border(width = 2.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp))
                                            .padding(5.dp)
                                            .background(Darkgreen),

                                        ) {
                                        Text("100 Points", fontSize =15.sp, modifier = Modifier.padding(5.dp),
                                            color = Color.White)
                                    }
                                }
                                Row (
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceAround,

                                    ){
                                    KresekBesar()

                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text("Kresek Besar", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                                        CounterComponent()
                                    }
                                    Spacer(Modifier.width(20.dp))
                                    Box(
                                        modifier = Modifier
                                            .border(width = 2.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp))
                                            .padding(5.dp)
                                            .background(Darkgreen),

                                        ) {
                                        Text("100 Points", fontSize =15.sp, modifier = Modifier.padding(5.dp),
                                            color = Color.White)
                                    }
                                }

                            }
                    2 -> Column {
                        Row (
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround,

                            ){
                            KresekBesar()

                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text("Kresek Besar", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                                CounterComponent()
                            }
                            Spacer(Modifier.width(20.dp))
                            Box(
                                modifier = Modifier
                                    .border(width = 2.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp))
                                    .padding(5.dp)
                                    .background(Darkgreen),

                                ) {
                                Text("100 Points", fontSize =15.sp, modifier = Modifier.padding(5.dp),
                                    color = Color.White)
                            }
                        }
                        Row (
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround,

                            ){
                            KresekBesar()

                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text("Kresek Besar", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                                CounterComponent()
                            }
                            Spacer(Modifier.width(20.dp))
                            Box(
                                modifier = Modifier
                                    .border(width = 2.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp))
                                    .padding(5.dp)
                                    .background(Darkgreen),

                                ) {
                                Text("100 Points", fontSize =15.sp, modifier = Modifier.padding(5.dp),
                                    color = Color.White)
                            }
                        }
                        Row (
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround,

                            ){
                            KresekBesar()

                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text("Kresek Besar", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                                CounterComponent()
                            }
                            Spacer(Modifier.width(20.dp))
                            Box(
                                modifier = Modifier
                                    .border(width = 2.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp))
                                    .padding(5.dp)
                                    .background(Darkgreen),

                                ) {
                                Text("100 Points", fontSize =15.sp, modifier = Modifier.padding(5.dp),
                                    color = Color.White)
                            }
                        }

                    }
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MenuSampah(navController: NavController) {
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {navController.popBackStack()},
                    modifier = Modifier.width(200.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                ) {
                    Text(
                        "<",
                        textAlign = TextAlign.Start,
                        color = Color.Black,
                        fontSize = 30.sp,
                        modifier = Modifier.padding(0.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text("Pilah & Pilih", color = Color.Black, fontSize = 20.sp)
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            PilihNavigation()
            BotNavbar()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMenu() {
    val navController = rememberNavController()
    MenuSampah(navController)
}
