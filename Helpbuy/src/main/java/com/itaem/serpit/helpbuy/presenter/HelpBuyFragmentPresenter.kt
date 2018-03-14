package com.itaem.serpit.helpbuy.presenter

import android.util.Log
import com.example.baselibrary.presenter.view.BasePresenter
import com.example.baselibrary.rx.BaseSubscriber
import com.itaem.serpit.baselibrary.common.BaseConstant
import com.itaem.serpit.baselibrary.ext.execute
import com.itaem.serpit.helpbuy.data.protocol.AcceptedOrderResp
import com.itaem.serpit.helpbuy.data.protocol.HelperTable
import com.itaem.serpit.helpbuy.presenter.view.HelpBuyFragmentView
import com.itaem.serpit.helpbuy.service.HelpBuyService
import com.kotlin.base.utils.AppPrefsUtils

import javax.inject.Inject

/*
* 已接受的P层
* */
class HelpBuyFragmentPresenter @Inject constructor() :BasePresenter<HelpBuyFragmentView>(){
    @Inject
    lateinit var mService: HelpBuyService

    /*查看我代购的请求*/
    fun getMyHelpBuyTable(){
        mView.showLoading()
         mService.getMyHelpBuyTable(AppPrefsUtils.getInt(BaseConstant.KEY_SP_USERID)).execute(object :BaseSubscriber<List<HelperTable>>(mView){
             override fun onNext(t: List<HelperTable>) {
                    mView.onGetListSuccess(t)
                    Log.d("MYLIST","${t.size}")
             }

             override fun onError(e: Throwable?) {
                    Log.e("MYLIST",e.toString())
                     mView.hideLoading()
                     mView.onGetListFailed()
                 }
         },lifeCycleProvider)
    }

    fun agreeHelper(helperTableId:Int,acceptId:Int){
        mView.showLoading()
        mService.agreeHelper(helperTableId,acceptId).execute(object :BaseSubscriber<Boolean>(mView){
            override fun onNext(t:Boolean) {
                mView.onAgreeSuccess()
            }

            override fun onError(e: Throwable?) {

                mView.hideLoading()
                mView.onAgreeFailed()
            }
        },lifeCycleProvider)
    }

}
