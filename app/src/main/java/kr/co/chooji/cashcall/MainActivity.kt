package kr.co.chooji.cashcall

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kr.co.chooji.cashcall.app.Permission

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Permission(this)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        Permission(requestCode, permissions, grantResults)
    }
}