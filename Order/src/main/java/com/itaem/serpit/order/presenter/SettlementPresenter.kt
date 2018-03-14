package com.itaem.serpit.order.presenter

import com.example.baselibrary.presenter.view.BasePresenter
import com.example.baselibrary.rx.BaseSubscriber
import com.itaem.serpit.baselibrary.ext.execute
import com.itaem.serpit.order.data.protocol.PostOrderReq
import com.itaem.serpit.order.presenter.view.SettlementView
import com.itaem.serpit.order.service.OrderService

import javax.inject.Inject

/*
* 的P层
* */
class SettlementPresenter @Inject constructor() :BasePresenter<SettlementView>(){
    @Inject
    lateinit var mService: OrderService

    /*查看商店详情*/
    fun postOrder(postOrderReq: PostOrderReq){
         mView.showLoading()
         mService.postOrder(postOrderReq).execute(object :BaseSubscriber<Boolean>(mView){
             override fun onNext(t: Boolean) {
                 mView.onPostOrderSuccess()
             }

             override fun onError(e: Throwable?) {
                 mView.onPostOrderFail()
             }
         },lifeCycleProvider)
    }



}
