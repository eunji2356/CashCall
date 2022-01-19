package kr.co.chooji.cashcall

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kr.co.chooji.cashcall.app.Permission
import kr.co.chooji.cashcall.home.HomeFragment
import kr.co.chooji.cashcall.mypage.MyPageFragment

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Permission(this)
    }

    private fun showFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_container, fragment)
            .commit()
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.home_btn -> {
                showFragment(HomeFragment())
            }
            R.id.my_page_btn -> {
                showFragment(MyPageFragment())
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        Permission(requestCode, permissions, grantResults)
    }
}