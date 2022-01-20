package kr.co.chooji.cashcall.app

import android.app.Activity
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

/**
 * 퍼미션 권한 체크
 */
class Permission {

    companion object{
        const val PERMISSION_CODE = 1
        lateinit var  activity: Activity
    }

    private val PERMISSIONS = arrayOf(
        android.Manifest.permission.READ_CALL_LOG
    )

    constructor(getActivity: Activity){
        activity = getActivity
        reqPermissions()
    }

    constructor(requestCode: Int, permissions: Array<String>, grantResults: IntArray){
        onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    private fun hasPermissions(): Boolean{
        PERMISSIONS.forEach { permission ->
            if(ContextCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED){
                return false
            }
        }
        return true
    }

    private fun reqPermissions(){
        if(!hasPermissions()){
            ActivityCompat.requestPermissions(activity, PERMISSIONS, PERMISSION_CODE)
        }
    }

    private fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray){
        if(PERMISSION_CODE == requestCode && PERMISSIONS.size == permissions.size){
            var checkResult = false

            loop@ for(i in permissions.indices){
                if(ActivityCompat.checkSelfPermission(activity, permissions[i]) != PackageManager.PERMISSION_GRANTED){
                    checkResult = true
                    break@loop
                }
            }

            if(checkResult) {
                var refusal = false
                loop@ for (i in permissions.indices) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(activity,permissions[i])) {
                        refusal = true
                        break@loop
                    }
                }

                if (refusal) {
                    Toast.makeText(activity, "퍼미션이 거부되었습니다. 앱을 다시 실행하여 퍼미션을 허용해주세요.", Toast.LENGTH_SHORT).show()
                }
                else {
                    Toast.makeText(activity, "퍼미션이 거부되었습니다. 설정(애플리케이션 정보)에서 퍼미션을 허용해야 합니다.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

