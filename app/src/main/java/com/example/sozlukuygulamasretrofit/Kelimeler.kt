package com.example.sozlukuygulamasretrofit


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Kelimeler(
    @SerializedName("ingilizce")
    val ingilizce: String?,
    @SerializedName("kelime_id")
    val kelimeİd: String?,
    @SerializedName("turkce")
    val turkce: String?
):Serializable