package kr.co.chooji.cashcall.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kr.co.chooji.cashcall.R
import kr.co.chooji.cashcall.home.service.LuckService

class HomeFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        LuckService.getTodayLuck()

        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}