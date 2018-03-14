package com.itaem.serpit.helpbuy.ui.fragment

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.baselibrary.ui.fragment.BaseMvpFragment
import com.itaem.serpit.baselibrary.common.BaseConstant
import com.itaem.serpit.helpbuy.data.protocol.GetAllHelperTableReq
import com.itaem.serpit.helpbuy.data.protocol.HelpBuyRequestInfo
import com.itaem.serpit.helpbuy.injection.component.DaggerHelpBuyFragmentComponent
import com.itaem.serpit.helpbuy.injection.module.HelpBuyModule
import com.itaem.serpit.helpbuy.presenter.NewReqPresenter
import com.itaem.serpit.helpbuy.presenter.view.NewReqView
import com.itaem.serpit.helpbuy.ui.adapter.NewReqAdapter
import com.itaem.serpit.mvpservicemarket.helpbuy.R

import com.kotlin.base.utils.AppPrefsUtils
import kotlinx.android.synthetic.main.fragment_new_req.*
import kotlinx.android.synthetic.main.item_new_req.view.*
import org.jetbrains.anko.support.v4.toast

/**
 * “新请求”
 */
class NewReqFragment : BaseMvpFragment<NewReqPresenter>(),NewReqView{
    private lateinit var adapter:NewReqAdapter



    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater?.inflate(R.layout.fragment_new_req,null)
    }

    override fun onResume() {
        super.onResume()
        loadData()
    }
    private fun loadData() {
        adapter =  NewReqAdapter(activity,mPresenter)
        showLoading()
        mPresenter.getAllHelperTable(GetAllHelperTableReq(1,20))
    }




    override fun onGetAllHelperTableResult(result: HelpBuyRequestInfo) {
        adapter.setData(result.rows)
        mNewReqRv.adapter = adapter

    }

    /*
    * 接单成功回调
    * */
    override fun onAcceptOrderSuccess() {
        toast("接单成功")
        mPresenter.getAllHelperTable(GetAllHelperTableReq(1,20))

    }

    /*
    * 接单失败回调
    * */
    override fun onAcceptOrderFailed() {
        toast("接单失败")
    }

    override fun injectComponent() {
        DaggerHelpBuyFragmentComponent.builder().fragmentComponent(fragmentComponent).helpBuyModule(HelpBuyModule()).build().inject(this)
        mPresenter.mView = this
    }
}