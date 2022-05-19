package com.example.sozlukuygulamasretrofit

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface KelimelerDaoInterface {
    @GET("sozluk/tum_kelimeler.php")
    fun tumKelimeler() : Call<KelimelerCevap>
    @POST("sozluk/kelime_ara.php")
    @FormUrlEncoded
    fun kelimeAra(@Field("ingilizce") ingilizce:String) : Call<KelimelerCevap>
}