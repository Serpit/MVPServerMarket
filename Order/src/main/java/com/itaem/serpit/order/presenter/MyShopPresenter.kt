package com.itaem.serpit.order.presenter

import com.example.baselibrary.presenter.view.BasePresenter
import com.example.baselibrary.rx.BaseSubscriber
import com.itaem.serpit.baselibrary.common.BaseConstant
import com.itaem.serpit.baselibrary.ext.execute
import com.itaem.serpit.order.data.protocol.GetMyShopInfoResp
import com.itaem.serpit.order.presenter.view.MyShopView
import com.itaem.serpit.order.service.OrderService
import com.kotlin.base.utils.AppPrefsUtils

import javax.inject.Inject

/*
* 我的商店的P层
* */
class MyShopPresenter @Inject constructor() :BasePresenter<MyShopView>(){
    @Inject
    lateinit var mService: OrderService

    /*查看商店详情*/
    fun loadShopInfo(){
         mView.showLoading()
         mService.getMyShopDetail(AppPrefsUtils.getInt(BaseConstant.KEY_SP_USERID)).execute(object :BaseSubscriber<GetMyShopInfoResp>(mView){
             override fun onNext(t: GetMyShopInfoResp) {
                mView.onGetMyShopInfoSuccess(t)
                 AppPrefsUtils.putInt(BaseConstant.KEY_SP_SHOP_ID,t.id)
             }

             override fun onError(e: Throwable?) {
                mView.onGetMyShopInfoFailed()
             }
         },lifeCycleProvider)
    }



}
