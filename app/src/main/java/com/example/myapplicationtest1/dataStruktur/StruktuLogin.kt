package com.example.myapplicationtest1.dataStruktur

data class datausers(
    val Id : Int,
    val Nama : String,
    val Password : String,
    val NumberPhone : String
)

data class loginResponse(
    val status : String,
    val message : String,
    val User_id : String
)

data class loginRequest(
    val Nama: String,
    val Password: String
)