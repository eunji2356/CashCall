package kr.co.chooji.cashcall

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kr.co.chooji.cashcall.app.Permission
import kr.co.chooji.cashcall.home.HomeFragment
import kr.co.chooji.cashcall.mypage.MyPageFragment

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Permission(this)

        initView()
        initClickEvent()
    }

    private fun initView(){
        showFragment(HomeFragment())
    }

    private fun showFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_container, fragment)
            .commit()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        Permission(requestCode, permissions, grantResults)
    }

    private fun initClickEvent(){
        home_btn.setOnClickListener(this)
        my_page_btn.setOnClickListener(this)
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
}