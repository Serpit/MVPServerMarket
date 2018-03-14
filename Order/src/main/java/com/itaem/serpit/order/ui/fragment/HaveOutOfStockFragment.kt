package com.itaem.serpit.order.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.baselibrary.ui.fragment.BaseFragment
import com.itaem.serpit.mvpservicemarket.order.R

/**
 * 已下架
 */
class HaveOutOfStockFragment :BaseFragment() {
    //lateinit var adapter:AcceptedAdapter
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         super.onCreateView(inflater, container, savedInstanceState)

         return inflater?.inflate(R.layout.fragment_have_been_out,null)
    }



}