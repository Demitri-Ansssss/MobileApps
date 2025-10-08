package com.example.myapplicationtest1

import android.content.Context
import android.telecom.Call
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

import com.example.myapplicationtest1.ui.theme.Darkgreen


@Composable
fun CustomtextField(
    label: String,
    stateText: String,
    onChange: (String) -> Unit,
    isPassword: Boolean = false)
{
    OutlinedTextField(
        value = stateText,
        onValueChange = onChange,
        label = { Text(text = label) },
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(keyboardType = if (isPassword) KeyboardType.Password else KeyboardType.Text),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun ImageLogin() {
    Image(
        painter = painterResource(id = R.drawable.logo),
        contentDescription = "Logo Apps",
        modifier = Modifier
            .width(100.dp)
            .height(100.dp)
            .background(color = Color.White)
            .clip(CircleShape),
        contentScale = ContentScale.FillHeight
    )
}

data class Users(
    val Username: String,
    val Password: String
)
 val users = listOf(
     Users(Username = "ansori", Password = "1234"),
     Users(Username = "sonya", Password = "1234"),
     Users(Username = "gea", Password = "1234"),

 )

@Composable
fun LoginPage(navController: NavController){
    var Username by remember { mutableStateOf("") }
    var Password by remember { mutableStateOf("") }
    var loginResult by remember { mutableStateOf("") }
    var errormsg by remember { mutableStateOf("") }
    

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Image with clip
        ImageWithClip()
        Text(text = "Login CleanGo", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(20.dp))


        // NamaTextField
        TextField(
            value = Username,
            onValueChange = {Username = it},
            label = {Text("Username")},
            modifier = Modifier.fillMaxWidth()

        )

        Spacer(modifier = Modifier.height(16.dp))

        // Password TextField
        TextField(
            value = Password,
            onValueChange = {Password = it},
            label = {Text("Password")},
            modifier = Modifier.fillMaxWidth()

        )

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth(),
            onClick = {
                    val users = users.find { it.Username == Username && it.Password == Password}
                if (users != null){
                    navController.navigate("HomePage")
                }else{
                    errormsg = "Login Gagal"
                }
            },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Darkgreen)
        ) {
            Text(
                "Login",
                modifier = Modifier.padding(10.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = loginResult)

        val RegisterText = buildAnnotatedString {
            append("Do you already have an account? ")

            withStyle(
                style = SpanStyle(
                    color = Color.Blue,
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline
                )
            ) {
                append("Register")
            }

        }
        ClickableText(
            text = RegisterText,
            modifier = Modifier.padding(end = 100.dp),
            onClick = { offset ->
                navController.navigate("RegisterPage")
                // Misalnya, navigasi ke halaman login
                if (offset >= RegisterText.length - "RegisterPage".length) {

                }
            }
        )


    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginPage(){
    val  navController = rememberNavController()
    LoginPage(navController)
}