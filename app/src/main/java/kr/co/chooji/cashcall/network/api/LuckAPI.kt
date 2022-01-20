package kr.co.chooji.cashcall.network.api

import kr.co.chooji.cashcall.home.dto.LuckDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface LuckAPI {
    @GET("day")
    fun getTodayLuck(
        @Query("api-key") apiKey: String,
        @Query("targetYear") targetYear: String,
        @Query("targetMonth") targetMonth: String,
        @Query("targetDay") targetDay: String,
        @Query("birthYear") birthYear: String,
        @Query("birthMonth") birthMonth: String,
        @Query("birthDay") birthDay: String,
        @Query("birthHour") birthHour: String,
        @Query("isLunar") isLunar: String
    ): Call<LuckDto>
}