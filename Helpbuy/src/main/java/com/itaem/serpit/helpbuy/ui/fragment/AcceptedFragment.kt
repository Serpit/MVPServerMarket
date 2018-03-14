package com.itaem.serpit.helpbuy.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.baselibrary.ui.fragment.BaseMvpFragment
import com.itaem.serpit.baselibrary.common.BaseConstant
import com.itaem.serpit.helpbuy.data.protocol.AcceptedOrderResp
import com.itaem.serpit.helpbuy.data.protocol.Data
import com.itaem.serpit.helpbuy.data.protocol.HelperTable
import com.itaem.serpit.helpbuy.injection.component.DaggerHelpBuyFragmentComponent
import com.itaem.serpit.helpbuy.injection.module.HelpBuyModule
import com.itaem.serpit.helpbuy.presenter.AcceptedPresenter
import com.itaem.serpit.helpbuy.presenter.view.AcceptedView
import com.itaem.serpit.helpbuy.ui.adapter.AcceptedAdapter
import com.itaem.serpit.mvpservicemarket.helpbuy.R

import com.kotlin.base.utils.AppPrefsUtils
import kotlinx.android.synthetic.main.fragment_accepted.*
import org.jetbrains.anko.support.v4.toast

/**
 * 已接受
 */
class AcceptedFragment :BaseMvpFragment<AcceptedPresenter>(),AcceptedView {
    lateinit var adapter:AcceptedAdapter
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         super.onCreateView(inflater, container, savedInstanceState)
         return inflater?.inflate(R.layout.fragment_accepted,null)
    }


    override fun onResume() {
        super.onResume()
        loadData()
    }


    private fun loadData() {
        adapter = AcceptedAdapter(activity,mPresenter)
        mPresenter.getMyAccept(AppPrefsUtils.getInt(BaseConstant.KEY_SP_USERID))
    }

    override fun onDeleteAcceptedOrderSuccess() {
        toast("取消代购成功")
        loadData()
    }

    override fun onDeleteAcceptedOrderFailed() {
        toast("取消代购失败，出现未知错误")
    }

    override fun onGetMyAcceptedResult(list: List<Data>) {
        mAcceptRv.adapter = adapter
        adapter.setData(list)
    }

    override fun injectComponent() {
        DaggerHelpBuyFragmentComponent.builder().fragmentComponent(fragmentComponent).helpBuyModule(HelpBuyModule()).build().inject(this)
        mPresenter.mView = this
    }
}