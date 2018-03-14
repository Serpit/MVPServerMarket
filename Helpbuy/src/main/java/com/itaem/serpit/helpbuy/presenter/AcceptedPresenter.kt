package com.itaem.serpit.helpbuy.presenter

import android.util.Log
import com.example.baselibrary.presenter.view.BasePresenter
import com.example.baselibrary.rx.BaseSubscriber
import com.itaem.serpit.baselibrary.ext.execute
import com.itaem.serpit.helpbuy.data.protocol.AcceptedOrderResp
import com.itaem.serpit.helpbuy.data.protocol.HelperTable
import com.itaem.serpit.helpbuy.presenter.view.AcceptedView
import com.itaem.serpit.helpbuy.service.HelpBuyService

import javax.inject.Inject

/*
* 已接受的P层
* */
class AcceptedPresenter @Inject constructor() :BasePresenter<AcceptedView>(){
    @Inject
    lateinit var mService: HelpBuyService

    /*查看我接受的代购*/
    fun getMyAccept(helperId:Int){
         mService.getMyHelperTable(helperId).execute(object :BaseSubscriber<AcceptedOrderResp>(mView){
             override fun onNext(t: AcceptedOrderResp) {
                 Log.d("SIZE","${t.data.size}")
                 mView.onGetMyAcceptedResult(t.data)
             }

             override fun onError(e: Throwable?) {
                 Log.e("ERROR",e.toString())
             }
         },lifeCycleProvider)
    }


    fun delete( helperAcceptId:Int){
        mService.deleteAccept(helperAcceptId).execute(object :BaseSubscriber<Boolean>(mView){
            override fun onNext(t: Boolean) {

               if(t) mView.onDeleteAcceptedOrderSuccess()
                else mView.onDeleteAcceptedOrderFailed()
            }

            override fun onError(e: Throwable?) {
                mView.onDeleteAcceptedOrderFailed()
            }
        },lifeCycleProvider)
    }


}
