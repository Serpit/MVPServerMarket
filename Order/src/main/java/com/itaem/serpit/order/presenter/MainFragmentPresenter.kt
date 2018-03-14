package com.itaem.serpit.order.presenter

import com.example.baselibrary.presenter.view.BasePresenter
import com.example.baselibrary.rx.BaseSubscriber
import com.itaem.serpit.baselibrary.ext.execute
import com.itaem.serpit.order.data.protocol.ShopInfo
import com.itaem.serpit.order.presenter.view.ShopListView
import com.itaem.serpit.order.service.OrderService
import javax.inject.Inject

/*
* 主页面的P层
* */
class MainFragmentPresenter @Inject constructor() :BasePresenter<ShopListView>(){
    @Inject
    lateinit var mService: OrderService

    /*查看商店列表*/
    fun getShopsList(marketId:Int){
        if (!checkNetWork()){
            return
        }
         mService.getShops(marketId).execute(object :BaseSubscriber<List<ShopInfo>>(mView){
             override fun onNext(t: List<ShopInfo>) {
                 mView.onGetShopsListResult(t)
             }

             override fun onError(e: Throwable?) {
                 mView.onGetShopsListFailed()
                 mView.hideLoading()
             }
         },lifeCycleProvider)
    }



}
