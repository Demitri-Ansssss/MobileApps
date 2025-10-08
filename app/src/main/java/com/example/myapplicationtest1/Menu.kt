package com.example.myapplicationtest1

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplicationtest1.ui.theme.Darkgreen
import com.example.myapplicationtest1.ui.theme.Lightgreen

var kresekBesarCount by mutableIntStateOf(0)
var kresekSedangCount by mutableIntStateOf(0)
var kresekKecilCount by mutableIntStateOf(0)
var pointbesar by mutableIntStateOf(100)
var pointsedang by mutableIntStateOf(75)
var pointkecil by mutableIntStateOf(50)

@SuppressLint("AutoboxingStateCreation")
class CounterViewModel : ViewModel() {

    val totalCount: Int
        get() = kresekBesarCount + kresekSedangCount + kresekKecilCount

    val totalpointbesar : Int
        get() = kresekBesarCount * pointbesar

    val totalpointsedang : Int
        get() = kresekSedangCount * pointsedang

    val totalpointkecil : Int
        get() = kresekKecilCount * pointkecil
    val totalpoint : Int
        get() = totalpointbesar + totalpointsedang + totalpointkecil

    fun resetCounters() {
        kresekBesarCount = 0
        kresekSedangCount = 0
        kresekKecilCount = 0
    }
}


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
        contentDescription = "Kresek Besar",
        modifier = Modifier.width(150.dp).height(150.dp),
        contentScale = ContentScale.FillWidth
    )
}
@Composable
fun KresekSedang(){
    Image(
        painter = painterResource(id=R.drawable.kresekputih),
        contentDescription = "Kresek Sedang",
        modifier = Modifier.width(150.dp).height(150.dp),
        contentScale = ContentScale.FillWidth
    )
}

@Composable
fun CounterComponent(count: Int, onAdd: () -> Unit, onSubtract: () -> Unit) {
    Row(
        modifier = Modifier
            .padding(0.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        IconButton(
            onClick = onSubtract,
            modifier = Modifier.size(25.dp)
        ) {
            Text(
                text = "-",
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier
                    .background(Color.Gray, shape = RoundedCornerShape(4.dp))
                    .fillMaxSize(),
                textAlign = TextAlign.Center
            )
        }

        Text(
            text = count.toString(),
            fontSize = 20.sp,
            color = Color.Gray,
            modifier = Modifier
                .width(50.dp)
                .padding(horizontal = 8.dp),
            textAlign = TextAlign.Center
        )

        IconButton(
            onClick = onAdd,
            modifier = Modifier.size(25.dp)
        ) {
            Text(
                text = "+",
                fontSize = 20.sp,
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
    val viewModel: CounterViewModel = viewModel()

    val tabs = listOf("Sampah Campur", "Sampah Kering", "Sampah Basah")
    LaunchedEffect(selectedTabIndex) {
        viewModel.resetCounters()
    }
Column(modifier = Modifier.fillMaxWidth().height(580.dp).wrapContentHeight()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
            ,
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
                    0 -> Column {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            KresekBesar()

                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text("Kresek Besar", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                                Spacer(modifier = Modifier.height(5.dp))
                                CounterComponent(
                                    count = kresekBesarCount,
                                    onAdd = { kresekBesarCount++ },
                                    onSubtract = { if (kresekBesarCount > 0) kresekBesarCount-- }
                                )
                            }
                            Spacer(Modifier.width(20.dp))
                            Box(
                                modifier = Modifier
                                    .padding(5.dp)
                                    .background(Darkgreen, shape = RoundedCornerShape(10.dp))
                            ) {
                                Text(
                                    "${pointbesar} Points",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(5.dp),
                                    color = Color.White
                                )
                            }
                        }

                        // Counter for Kresek Sedang
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            KresekSedang()

                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    "Kresek Sedang",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 15.sp
                                )
                                Spacer(modifier = Modifier.height(5.dp))
                                CounterComponent(
                                    count = kresekSedangCount,
                                    onAdd = { kresekSedangCount++ },
                                    onSubtract = { if (kresekSedangCount > 0) kresekSedangCount-- }
                                )
                            }
                            Spacer(Modifier.width(20.dp))
                            Box(
                                modifier = Modifier
                                    .padding(5.dp)
                                    .background(Darkgreen, shape = RoundedCornerShape(10.dp))
                            ) {
                                Text(
                                    "${pointsedang} Points",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(5.dp),
                                    color = Color.White
                                )
                            }
                        }

                        // Counter for Kresek Kecil
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            KresekKecil()

                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text("Kresek Kecil", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                                Spacer(modifier = Modifier.height(5.dp))
                                CounterComponent(
                                    count = kresekKecilCount,
                                    onAdd = { kresekKecilCount++ },
                                    onSubtract = { if (kresekKecilCount > 0) kresekKecilCount-- }
                                )
                            }
                            Spacer(Modifier.width(20.dp))
                            Box(
                                modifier = Modifier
                                    .padding(5.dp)
                                    .background(Darkgreen, shape = RoundedCornerShape(10.dp))
                            ) {
                                Text(
                                    "${pointkecil} Points",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(5.dp),
                                    color = Color.White
                                )
                            }
                        }
                    }
                    1 -> Column {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            KresekBesar()

                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text("Kresek Besar", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                                Spacer(modifier = Modifier.height(5.dp))
                                CounterComponent(
                                    count = kresekBesarCount,
                                    onAdd = { kresekBesarCount++ },
                                    onSubtract = { if (kresekBesarCount > 0) kresekBesarCount-- }
                                )
                            }
                            Spacer(Modifier.width(20.dp))
                            Box(
                                modifier = Modifier
                                    .padding(5.dp)
                                    .background(Darkgreen, shape = RoundedCornerShape(10.dp))
                            ) {
                                Text(
                                    "${pointbesar} Points",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(5.dp),
                                    color = Color.White
                                )
                            }
                        }

                        // Counter for Kresek Sedang
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            KresekSedang()

                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    "Kresek Sedang",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 15.sp
                                )
                                Spacer(modifier = Modifier.height(5.dp))
                                CounterComponent(
                                    count = kresekSedangCount,
                                    onAdd = { kresekSedangCount++ },
                                    onSubtract = { if (kresekSedangCount > 0) kresekSedangCount-- }
                                )
                            }
                            Spacer(Modifier.width(20.dp))
                            Box(
                                modifier = Modifier
                                    .padding(5.dp)
                                    .background(Darkgreen, shape = RoundedCornerShape(10.dp))
                            ) {
                                Text(
                                    "${pointsedang} Points",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(5.dp),
                                    color = Color.White
                                )
                            }
                        }

                        // Counter for Kresek Kecil
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            KresekKecil()

                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text("Kresek Kecil", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                                Spacer(modifier = Modifier.height(5.dp))
                                CounterComponent(
                                    count = kresekKecilCount,
                                    onAdd = { kresekKecilCount++ },
                                    onSubtract = { if (kresekKecilCount > 0) kresekKecilCount-- }
                                )
                            }
                            Spacer(Modifier.width(20.dp))
                            Box(
                                modifier = Modifier
                                    .padding(5.dp)
                                    .background(Darkgreen, shape = RoundedCornerShape(10.dp))
                            ) {
                                Text(
                                    "${pointkecil} Points",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(5.dp),
                                    color = Color.White
                                )
                            }
                        }
                    }
                    2 -> Column {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            KresekBesar()

                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text("Kresek Besar", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                                Spacer(modifier = Modifier.height(5.dp))
                                CounterComponent(
                                    count = kresekBesarCount,
                                    onAdd = { kresekBesarCount++ },
                                    onSubtract = { if (kresekBesarCount > 0) kresekBesarCount-- }
                                )
                            }
                            Spacer(Modifier.width(20.dp))
                            Box(
                                modifier = Modifier
                                    .padding(5.dp)
                                    .background(Darkgreen, shape = RoundedCornerShape(10.dp))
                            ) {
                                Text(
                                    "${pointbesar} Points",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(5.dp),
                                    color = Color.White
                                )
                            }
                        }

                        // Counter for Kresek Sedang
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            KresekSedang()

                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    "Kresek Sedang",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 15.sp
                                )
                                Spacer(modifier = Modifier.height(5.dp))
                                CounterComponent(
                                    count = kresekSedangCount,
                                    onAdd = { kresekSedangCount++ },
                                    onSubtract = { if (kresekSedangCount > 0) kresekSedangCount-- }
                                )
                            }
                            Spacer(Modifier.width(20.dp))
                            Box(
                                modifier = Modifier
                                    .padding(5.dp)
                                    .background(Darkgreen, shape = RoundedCornerShape(10.dp))
                            ) {
                                Text(
                                    "${pointsedang} Points",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(5.dp),
                                    color = Color.White
                                )
                            }
                        }

                        // Counter for Kresek Kecil
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            KresekKecil()

                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text("Kresek Kecil", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                                Spacer(modifier = Modifier.height(5.dp))
                                CounterComponent(
                                    count = kresekKecilCount,
                                    onAdd = { kresekKecilCount++ },
                                    onSubtract = { if (kresekKecilCount > 0) kresekKecilCount-- }
                                )
                            }
                            Spacer(Modifier.width(20.dp))
                            Box(
                                modifier = Modifier
                                    .padding(5.dp)
                                    .background(Darkgreen, shape = RoundedCornerShape(10.dp))
                            ) {
                                Text(
                                    "${pointkecil} Points",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(5.dp),
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Validation(navController: NavController){
    val viewModel: CounterViewModel = viewModel()
    Box(){
        Box (
            modifier = Modifier
                .border(2.dp, Color.DarkGray, shape = RoundedCornerShape(10.dp))
                .align(Alignment.BottomCenter)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Darkgreen, shape = RoundedCornerShape(10.dp)),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Total ${viewModel.totalCount} Items", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 15.sp, modifier = Modifier.padding(20.dp))
                Button(
                    enabled = viewModel.totalCount != 0,
                    onClick = {navController.navigate("detail page/${R.drawable.kresekhitam}/${"Kresek Besar"}/${viewModel.totalCount}")},
                    colors = ButtonDefaults.buttonColors(containerColor = Darkgreen),

                    ) {
                    Row(
                        modifier = Modifier
                            .padding(0.dp)
                            .border(2.dp, Color.White, shape = RoundedCornerShape(10.dp)),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text("Confirm",color = Color.White, fontWeight = FontWeight.Bold, fontSize = 17.sp, modifier = Modifier
                            .padding(5.dp))
                        Spacer(modifier = Modifier.width(2.dp))
                        Text(">",color = Color.White, fontWeight = FontWeight.Bold, fontSize = 20.sp, modifier = Modifier
                            .padding(5.dp))
                    }
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MenuSampah(navController: NavController) {
    val viewModel: CounterViewModel = viewModel()
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding( 10.dp)
                    .clickable{
                        navController.navigate("HomePage")
                    }
                    .padding(top = 10.dp),
                verticalAlignment = Alignment.CenterVertically
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
            Spacer(modifier = Modifier.height(10.dp))
            PilihNavigation()
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .zIndex(2f)
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Validation(navController)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMenu() {
    val navController = rememberNavController()
    MenuSampah(navController)
}
