package com.example.myapplicationtest1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapplicationtest1.ui.theme.Darkgreen

import androidx.compose.material3.*
import androidx.compose.runtime.*

import androidx.compose.foundation.layout.Arrangement

import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp

import androidx.compose.ui.Alignment
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

var Pembayaran by  mutableStateOf("")
var locationText by  mutableStateOf("")


class ListMaps : ViewModel(){
    val _selectedLocation = MutableStateFlow("momomomom")
    val selectedLocation: StateFlow<String> = _selectedLocation

    fun selectLocation(location: String) {
        _selectedLocation.value = location
    }
    val preparedLocations = listOf(
        "Jl. Sudirman No. 10, Jakarta",
        "Jl. Gatot Subroto No. 22, Bandung",
        "Jl. Diponegoro No. 5, Surabaya",
        "Jl. Ahmad Yani No. 12, Yogyakarta",
        "Jl. Gajah Mada No. 20, Semarang"
    )
    val ListPembayaran  = listOf(
        "Dana",
        "Ovo",
        "Transfer Bank"
    )

}

@Composable
fun LocationInputWithPreparedList() {

    // State untuk menampilkan dropdown
    var isDropdownVisible by remember { mutableStateOf(false) }
    val viewModel: ListMaps = viewModel()
    val selectedLocation by viewModel.selectedLocation.collectAsState()

    // Layout utama
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {
        Column {
            // Input lokasi dengan Icon
            OutlinedTextField(
                value = locationText,
                onValueChange = {},
                label = { Text("Select Location") },
                readOnly = true,
                trailingIcon = {
                    Icon(
                        imageVector = if (isDropdownVisible)
                            Icons.Default.KeyboardArrowUp
                        else
                            Icons.Default.KeyboardArrowDown,
                        contentDescription = "Dropdown Icon",
                        modifier = Modifier
                            .clickable { isDropdownVisible = !isDropdownVisible }
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { isDropdownVisible = true } // Membuka dropdown ketika input diklik
            )

            // Dropdown Menu
            DropdownMenu(
                expanded = isDropdownVisible,
                onDismissRequest = { isDropdownVisible = false },
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                viewModel.preparedLocations.forEach { location ->
                    DropdownMenuItem(
                        text = { Text(location) },
                        onClick = {
                            locationText = location
                            viewModel.selectLocation(location)
                            isDropdownVisible = false
                        }
                    )
                }
            }
        }
    }
}
@Composable
fun ConfirmPembayaran(navController: NavController?) {
    var isDropdownVisible by remember { mutableStateOf(false) }
    val viewModel: CounterViewModel = viewModel()
    val viewModel2: ListMaps = viewModel()



    Box(
    ) {
        // Tampilan konten dalam Card
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .padding(10.dp)
                .background(Color.Gray, shape = RoundedCornerShape(10.dp))
                .align(Alignment.BottomCenter),
            ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Row untuk menampilkan Items dan Point
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.icontotalitems),
                        contentDescription = "Items Icon",
                        modifier = Modifier.size(30.dp)
                    )
                    Text(text = "${viewModel.totalCount} Items", fontWeight = FontWeight.Bold, fontSize = 16.sp)

                    Spacer(modifier = Modifier.weight(1f))

                    Image(
                        painter = painterResource(R.drawable.icontotalpoints),
                        contentDescription = "Items Icon",
                        modifier = Modifier.size(30.dp)
                    )
                    Text("${viewModel.totalpoint} Point", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }

                // Text Input dengan Label
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // Input lokasi dengan Icon
                    OutlinedTextField(
                        value = Pembayaran,
                        onValueChange = {},
                        label = { Text("Select Pembayaran") },
                        readOnly = true,
                        trailingIcon = {
                            Icon(
                                imageVector = if (isDropdownVisible)
                                    Icons.Default.KeyboardArrowUp
                                else
                                    Icons.Default.KeyboardArrowDown,
                                contentDescription = "Dropdown Icon",
                                modifier = Modifier
                                    .clickable { isDropdownVisible = !isDropdownVisible }
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { isDropdownVisible = !isDropdownVisible} // Membuka dropdown ketika input diklik
                    )

                    // Dropdown Menu
                    DropdownMenu(
                        expanded = isDropdownVisible,
                        onDismissRequest = { isDropdownVisible = false },
                        modifier = Modifier
                            .width(100.dp)
                    ) {
                        viewModel2.ListPembayaran.forEach { location ->
                            DropdownMenuItem(
                                text = { Text(location) },
                                onClick = {
                                    Pembayaran = location
                                    isDropdownVisible = false
                                }
                            )
                        }
                    }

                }


                // Tombol Panggil Petugas
                Button(
                    onClick ={navController?.navigate("Detail Pembayaran")},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Darkgreen)
                ) {
                    Text(
                        text = "PANGGIL PETUGAS",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}

@Composable
fun DetailPage(iconId: Int?, name: String?, navController: NavController?,viewModel : ViewModel?) {
    val viewModel : CounterViewModel = viewModel()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .clickable {
                        navController?.navigate("Menu")
                    },
                horizontalArrangement = Arrangement.Start,
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
                Text("Panggil Petugas", color = Color.Black, fontSize = 20.sp)

            }

            LocationInputWithPreparedList()
        Column (

        ){
            if (kresekBesarCount != 0) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    iconId?.let {
                        Image(
                            painter = painterResource(id = R.drawable.kresekhitam),
                            contentDescription = null,
                            modifier = Modifier.size(100.dp)
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceAround
                    ) {
                        Text("Kresek Besar", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                        Spacer(modifier = Modifier.height(8.dp))
                        Box(
                            modifier = Modifier
                                .padding(2.dp)
                                .background(Darkgreen, shape = RoundedCornerShape(10.dp))
                        ) {
                            Text(
                                "${viewModel.totalpointbesar} Points",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(3.dp),
                                color = Color.White
                            )
                        }
                    }
                    Column(
                        horizontalAlignment = Alignment.End,
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        Text(" ${kresekBesarCount.toString()} Items", fontSize = 16.sp)
                    }
                }
            }
//        kresek sedang
            if (kresekSedangCount != 0) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    iconId?.let {
                        Image(
                            painter = painterResource(id = R.drawable.kresekputih),
                            contentDescription = null,
                            modifier = Modifier.size(100.dp)
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceAround
                    ) {
                        Text("Kresek Sedang", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                        Spacer(modifier = Modifier.height(8.dp))
                        Box(
                            modifier = Modifier
                                .padding(2.dp)
                                .background(Darkgreen, shape = RoundedCornerShape(10.dp))
                        ) {
                            Text(
                                "${viewModel.totalpointsedang} Points",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(3.dp),
                                color = Color.White
                            )
                        }
                    }
                    Column(
                        horizontalAlignment = Alignment.End,
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        Text(" ${kresekSedangCount.toString()} Items", fontSize = 16.sp)
                    }
                }
            }
//        kresek kecil
            if (kresekKecilCount != 0) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    iconId?.let {
                        Image(
                            painter = painterResource(id = R.drawable.kresekkecil),
                            contentDescription = null,
                            modifier = Modifier.size(100.dp)
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceAround
                    ) {
                        Text("Kresek Kecil", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                        Spacer(modifier = Modifier.height(8.dp))
                        Box(
                            modifier = Modifier
                                .padding(2.dp)
                                .background(Darkgreen, shape = RoundedCornerShape(10.dp))
                        ) {
                            Text(
                                "${viewModel.totalpointkecil} Points",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(3.dp),
                                color = Color.White
                            )
                        }
                    }
                    Column(
                        horizontalAlignment = Alignment.End,
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        Text(" ${kresekKecilCount.toString()} Items", fontSize = 16.sp)
                    }
                }
            }
        }
        }

        ConfirmPembayaran(navController = navController)
    }
}


@Preview
@Composable
fun PrevConfirm(){
    DetailPage(iconId = R.drawable.kresekhitam, name = "kresek besar", null , null)
}