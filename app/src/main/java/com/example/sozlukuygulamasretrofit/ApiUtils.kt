package com.example.sozlukuygulamasretrofit

class ApiUtils {
    companion object{
        val BASE_URL="http://kasimadalan.pe.hu/"
        fun getKelimelerDoaInterface():KelimelerDaoInterface{
            return RetrofitClient.getClient(BASE_URL).create(KelimelerDaoInterface::class.java)
        }
    }
}