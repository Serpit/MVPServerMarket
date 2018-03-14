package com.itaem.serpit.order.presenter

import com.example.baselibrary.presenter.view.BasePresenter
import com.example.baselibrary.rx.BaseSubscriber
import com.itaem.serpit.baselibrary.ext.execute
import com.itaem.serpit.order.data.protocol.GroupReq
import com.itaem.serpit.order.presenter.view.AddShopTeamBuyView
import com.itaem.serpit.order.service.OrderService
import javax.inject.Inject

/*
*添加团购的P层
* */
class AddShopTeamBuyPresenter @Inject constructor() :BasePresenter<AddShopTeamBuyView>(){
    @Inject
    lateinit var mService: OrderService

    /*上架一个团购*/
    fun group(groupReq: GroupReq){
         mView.showLoading()
         mService.groups(groupReq).execute(object :BaseSubscriber<Boolean>(mView){
             override fun onNext(t:Boolean) {
                 if (t)
                    mView.onAddSuccess()
                 else
                     mView.onAddFailed()
             }

             override fun onError(e: Throwable?) {
                    mView.hideLoading()

             }
         },lifeCycleProvider)
    }




}
