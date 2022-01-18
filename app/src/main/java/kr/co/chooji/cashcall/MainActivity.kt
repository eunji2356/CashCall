package kr.co.chooji.cashcall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CallLog
import android.util.Log
import kr.co.chooji.cashcall.common.Permission
import java.lang.Exception

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Permission(this)
    }

    /**
     * 퍼미션 권한 체크
     */
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        Permission(requestCode, permissions, grantResults)
    }
}