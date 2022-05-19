package com.example.sozlukuygulamasretrofit


import com.google.gson.annotations.SerializedName

data class KelimelerCevap(
    @SerializedName("kelimeler")
    val kelimeler: List<Kelimeler>?,
    @SerializedName("success")
    val success: Int?
)