package com.itaem.serpit.helpbuy.presenter

import com.example.baselibrary.presenter.view.BasePresenter
import com.example.baselibrary.rx.BaseSubscriber
import com.itaem.serpit.baselibrary.ext.execute
import com.itaem.serpit.helpbuy.data.protocol.AcceptOrderReq
import com.itaem.serpit.helpbuy.data.protocol.GetAllHelperTableReq
import com.itaem.serpit.helpbuy.data.protocol.HelpBuyRequestInfo

import com.itaem.serpit.helpbuy.presenter.view.HelpBuyMsgView
import com.itaem.serpit.helpbuy.presenter.view.NewReqView
import com.itaem.serpit.helpbuy.service.HelpBuyService
import rx.Observable

import javax.inject.Inject


class NewReqPresenter @Inject constructor() :BasePresenter<NewReqView>(){
    @Inject
    lateinit var mService:HelpBuyService
    fun getAllHelperTable(getAllHelperTableReq: GetAllHelperTableReq){
          mService.getAllHelperTable(getAllHelperTableReq.page,getAllHelperTableReq.rows).execute(object : BaseSubscriber<HelpBuyRequestInfo>(mView){
              override fun onNext(t: HelpBuyRequestInfo) {
                    mView.onGetAllHelperTableResult(t)

              }
          },lifeCycleProvider)
    }

    fun acceptRequest(acceptOrderReq: AcceptOrderReq){
        mService.acceptRequest(acceptOrderReq).execute(object : BaseSubscriber<Boolean>(mView){
            override fun onNext(t: Boolean) {
                if(t){
                    mView.onAcceptOrderSuccess()
                }else{
                    mView.onAcceptOrderFailed()
                }

            }
        },lifeCycleProvider)
    }
}