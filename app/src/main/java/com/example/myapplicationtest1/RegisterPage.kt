package com.example.myapplicationtest1

import androidx.compose.foundation.Image
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
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationtest1.ui.theme.Darkgreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    label: String,
    stateText: String,
    onChange: (String) -> Unit,
    isPassword: Boolean = false
) {
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
fun ImageWithClip() {
    Image(
        painter = painterResource(id = R.drawable.logo),
        contentDescription = "Logo Apps",
        modifier = Modifier
            .width(100.dp)
            .height(100.dp)
            .clip(CircleShape),
        contentScale = ContentScale.FillHeight
    )
}
@Composable
 fun RegisterPage(){
    var Fullname by remember { mutableStateOf("") }
    var Email by remember { mutableStateOf("") }
    var NumberPhone by remember { mutableStateOf("") }
    var checked by remember { mutableStateOf( true) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Image with clip
        ImageWithClip()
        Text(text = "Create New Account", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(20.dp))


        // Username TextField
        CustomTextField(
            label = "Full Name",
            stateText = Fullname,
            onChange = { Fullname = it },
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Password TextField
        CustomTextField(
            label = "Email",
            stateText = Email,
            onChange = { Email = it },
//            isPassword = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Username TextField
        CustomTextField(
            label = "Number Phone",
            stateText = NumberPhone,
            onChange = { NumberPhone = it },
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.padding(end = 150.dp, start = 0.dp)
        ) {
            Checkbox(
                checked = checked,
                onCheckedChange = { checked = it }
            )
            Text(
                "Accept Term and Condition"
            )
        }
        Button(
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth(),
            onClick = {},
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Darkgreen) // Gunakan ButtonDefaults.buttonColors()
        ) {
            Text(
                "Create New Account",
                modifier = Modifier.padding(10.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White // Gunakan warna teks putih agar kontras dengan warna background
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
                append("Login")
            }
        }

        ClickableText(
            text = loginText,
            modifier = Modifier.padding(end = 170.dp),
            onClick = { offset ->
                // Aksi ketika "Login" diklik
                // Misalnya, navigasi ke halaman login
                if (offset >= loginText.length - "Login".length) {
                    // Panggil fungsi navigasi atau aksi lain di sini
                }
            }
        )

    }

 }