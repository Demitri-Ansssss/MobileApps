package com.example.myapplicationtest1

import android.content.Context
import android.net.Uri
import android.provider.OpenableColumns
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.MultipartBody
import okhttp3.Request
import okhttp3.RequestBody.Companion.asRequestBody
import org.json.JSONObject
import java.io.File

@Composable
fun Detection(navController: NavController) {
    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
    var predictionResult by remember { mutableStateOf<String?>(null) }
    var confidence by remember { mutableStateOf<String?>(null) }
    var predictionsLog by remember { mutableStateOf<List<Pair<String, String>>>(emptyList()) }
    var isLoading by remember { mutableStateOf(false) }
    val context = LocalContext.current

    // Launcher untuk memilih gambar
    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        selectedImageUri = uri
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .fillMaxHeight()
    ) {
        Text(
            "< Deteksi Jenis Sampah",
            fontSize = 25.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Row {
                Button(
                    onClick = { imagePicker.launch("image/*") },
                    modifier = Modifier
                        .width(150.dp)
                        .height(40.dp)
                ) {
                    Text(
                        text = if (selectedImageUri == null)
                            "Pilih Gambar"
                        else
                            "Ganti Gambar"
                    )
                }

                Button(
                    onClick = {
                        if (selectedImageUri != null) {
                            isLoading = true
                            CoroutineScope(Dispatchers.IO).launch {
                                // POST gambar untuk prediksi
                                val postResult = predictImage(selectedImageUri!!, context)

                                // GET log prediksi dari database
                                val logs = getLastPrediction()

                                withContext(Dispatchers.Main) {
                                    postResult?.let {
                                        predictionResult = it.first
                                        confidence = it.second
                                    } ?: Log.e("Detection", "POST Result is null")
                                    logs?.let {
                                        predictionResult = it.first
                                        confidence = it.second
                                    } ?: Log.e("Detection", "Predict Result is null")
                                }
                            }
                        }
                    },
                    modifier = Modifier
                        .width(150.dp)
                        .height(40.dp),
                    enabled = selectedImageUri != null && !isLoading
                ) {
                    Text("Deteksi")
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                if (selectedImageUri != null) {
                    Image(
                        painter = rememberAsyncImagePainter(selectedImageUri),
                        contentDescription = "Gambar yang dipilih",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Fit
                    )
                } else {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.surfaceVariant
                    ) {
                        Text(
                            text = "Belum ada gambar yang dipilih",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(16.dp),
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(50.dp))
            if (isLoading) {
                CircularProgressIndicator()
                Text("Sedang memproses...")
            } else {
                predictionResult?.let {
                    Text("Prediksi: $it")
                    Text("Akurasi: $confidence%")
                }
                predictionsLog.forEach { log ->
                    Text("Log: Prediksi = ${log.first}, Akurasi = ${log.second}%")
                }
            }
        }
    }
}

suspend fun predictImage(imageUri: Uri, context: Context): Pair<String, String>? {
    val client = OkHttpClient()
    val serverUrl = "https://df54-2400-9800-7c1-8f4c-a844-a5d1-c9e4-d3ed.ngrok-free.app/api/predict/" // Ganti dengan URL backend Django Anda

    return try {
        // 1. Konversi URI menjadi File
        val imageFile = createTempFileFromUri(context, imageUri)

        // 2. Siapkan request body multipart
        val requestBody = imageFile.asRequestBody("image/*".toMediaTypeOrNull())
        val multipartBody = MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart("image", imageFile.name, requestBody)
            .build()

        // 3. Buat request POST
        val request = Request.Builder()
            .url(serverUrl)
            .post(multipartBody)
            .build()

        // 4. Kirim request dan tangani respon
        val response = client.newCall(request).execute()
        if (response.isSuccessful) {
            val jsonResponse = response.body?.string()
            jsonResponse?.let {
                val jsonObject = JSONObject(it)
                val predictedClass = jsonObject.getString("predicted_class")
                val confidence = jsonObject.getDouble("confidence").toString()
                return Pair(predictedClass, confidence) // Kembalikan hasil prediksi
            }
        } else {
            Log.e("PredictImage", "HTTP Error: ${response.code} - ${response.message}")
            null
        }
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}


suspend fun getLastPrediction(): Pair<String, String>? {
    val client = OkHttpClient()
    val serverUrl = "https://df54-2400-9800-7c1-8f4c-a844-a5d1-c9e4-d3ed.ngrok-free.app/api/predict/last/" // Ganti dengan URL backend Django Anda

    return try {
        val request = Request.Builder()
            .url(serverUrl) // GET endpoint
            .get()
            .build()

        val response = client.newCall(request).execute()
        if (response.isSuccessful) {
            val jsonResponse = response.body?.string()
            jsonResponse?.let {
                val jsonObject = JSONObject(it)
                val predictedClass = jsonObject.getString("predicted_class")
                val confidence = jsonObject.getString("confidence")
                return Pair(predictedClass, confidence) // Kembalikan prediksi terakhir
            }
        } else {
            Log.e("GetLastPrediction", "HTTP Error: ${response.code} - ${response.message}")
            null
        }
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}


fun createTempFileFromUri(context: Context, uri: Uri): File {
    val inputStream = context.contentResolver.openInputStream(uri)
    val tempFile = File.createTempFile("temp_image", ".jpg", context.cacheDir) // Buat file sementara
    inputStream?.use { input ->
        tempFile.outputStream().use { output ->
            input.copyTo(output) // Salin isi file dari Uri ke file sementara
        }
    }
    return tempFile
}





@Preview
@Composable
fun ShowDetec(){
    val navController = rememberNavController()
    Detection(navController)
}