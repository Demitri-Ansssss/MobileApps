package com.example.myapplicationtest1

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

@Composable
fun LoginPage(navController: NavController){
    var Fullname by remember { mutableStateOf("") }
    var Email by remember { mutableStateOf("") }

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


        // Username TextField
        CustomTextField(
            label = "Username",
            stateText = Fullname,
            onChange = { Fullname = it },
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Password TextField
        CustomtextField(
            label = "Password",
            stateText = Email,
            onChange = { Email = it },
//            isPassword = true
        )

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth(),
            onClick = {navController.navigate("HomePage")},
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

        val loginText = buildAnnotatedString {
            append("Already have an account? ")

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
            text = loginText,
            modifier = Modifier.padding(end = 170.dp),
            onClick = { offset ->
                navController.navigate("RegisterPage")
                // Misalnya, navigasi ke halaman login
                if (offset >= loginText.length - "RegisterPage".length) {
                    // Panggil fungsi navigasi atau aksi lain di sini
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