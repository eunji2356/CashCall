package kr.co.chooji.cashcall.utils

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {

    fun getYear(): String{
        return SimpleDateFormat("yyyy", Locale.KOREA).format(Date())
    }

    fun getMonth(): String {
        return SimpleDateFormat("MM", Locale.KOREA).format(Date())
    }

    fun getDay(): String {
        return SimpleDateFormat("dd", Locale.KOREA).format(Date())
    }
}