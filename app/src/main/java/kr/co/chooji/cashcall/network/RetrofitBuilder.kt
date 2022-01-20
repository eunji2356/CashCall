package kr.co.chooji.cashcall.network

import kr.co.chooji.cashcall.network.api.LuckAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private const val BASE_URL = "https://api.un7.kr/api/v1/"

     private var retrofit: Retrofit = Retrofit.Builder()
         .baseUrl(BASE_URL)
         .addConverterFactory(GsonConverterFactory.create())
         .build()

    fun getLuckAPI(): LuckAPI = retrofit.create(LuckAPI::class.java)
}