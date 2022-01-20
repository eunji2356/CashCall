package kr.co.chooji.cashcall.home.service

import android.util.Log
import kr.co.chooji.cashcall.home.dto.LuckDto
import kr.co.chooji.cashcall.network.RetrofitBuilder
import kr.co.chooji.cashcall.network.api.LuckAPI
import kr.co.chooji.cashcall.utils.DateUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object LuckService {

    private var luckApi: LuckAPI = RetrofitBuilder.getLuckAPI()

    /**
     * 오늘의 운세 정보 불러오는 API
     * */
    fun getTodayLuck(){
        luckApi.getTodayLuck(
            "943156c8f56a4c88fad1ba1379e3bf00",
            DateUtils.getYear(),
            DateUtils.getMonth(),
            DateUtils.getDay(),
            "2000",
            "10",
            "14",
            "9",
            "false"
        ).enqueue(object: Callback<LuckDto> {
            override fun onResponse(call: Call<LuckDto>, response: Response<LuckDto>) {
                Log.e(">>>>> response : ", "$response")
            }

            override fun onFailure(call: Call<LuckDto>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}