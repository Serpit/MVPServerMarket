package com.itaem.serpit.order.presenter

import com.example.baselibrary.presenter.view.BasePresenter
import com.example.baselibrary.rx.BaseSubscriber
import com.itaem.serpit.baselibrary.common.BaseConstant
import com.itaem.serpit.baselibrary.ext.execute
import com.itaem.serpit.order.data.protocol.ShopDetail
import com.itaem.serpit.order.presenter.view.ChoseGoodTeamBuyView
import com.itaem.serpit.order.service.OrderService
import com.kotlin.base.utils.AppPrefsUtils
import javax.inject.Inject

/*
*添加团购的P层
* */
class ChoseGoodTeamBuyPresenter @Inject constructor() :BasePresenter<ChoseGoodTeamBuyView>(){
    @Inject
    lateinit var mService: OrderService


    fun getMyShopGoodList(){
        mView.showLoading()
        mService.getShopDetail(AppPrefsUtils.getInt(BaseConstant.KEY_SP_SHOP_ID)).execute(object :BaseSubscriber<ShopDetail>(mView){
            override fun onNext(t:ShopDetail) {
                mView.onGetListSuccess( t.data.goodList)
            }

            override fun onError(e: Throwable?) {
                mView.hideLoading()
                mView.onGetListFailed()
            }
        },lifeCycleProvider)
    }



}
