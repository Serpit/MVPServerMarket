package com.itaem.serpit.order.presenter

import android.util.Log
import com.example.baselibrary.presenter.view.BasePresenter
import com.example.baselibrary.rx.BaseSubscriber
import com.itaem.serpit.baselibrary.ext.execute
import com.itaem.serpit.order.data.protocol.ShopDetail
import com.itaem.serpit.order.presenter.view.ShopDetailView
import com.itaem.serpit.order.service.OrderService

import javax.inject.Inject

/*
* 商店详情的P层
* */
class ShopDetailPresenter @Inject constructor() :BasePresenter<ShopDetailView>(){
    @Inject
    lateinit var mService: OrderService

    /*查看商店详情*/
    fun getShopDetail(shopId:Int){
         mView.showLoading()
         mService.getShopDetail(shopId).execute(object :BaseSubscriber<ShopDetail>(mView){
             override fun onNext(t: ShopDetail) {
                 mView.onGetShopDetailResult(t)
             }

             override fun onError(e: Throwable?) {
                 mView.onGetShopDetailFailed()
                 Log.e("NETERROR",e.toString())
             }
         },lifeCycleProvider)
    }



}
