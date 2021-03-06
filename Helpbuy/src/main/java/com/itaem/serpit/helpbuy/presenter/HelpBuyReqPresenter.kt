package com.itaem.serpit.helpbuy.presenter

import android.util.Log
import com.example.baselibrary.presenter.view.BasePresenter
import com.example.baselibrary.rx.BaseSubscriber
import com.itaem.serpit.baselibrary.ext.execute
import com.itaem.serpit.helpbuy.data.protocol.CommitHelpBuyOrderReq
import com.itaem.serpit.helpbuy.presenter.view.HelpBuyReqView
import com.itaem.serpit.helpbuy.presenter.view.RequestDetailView
import com.itaem.serpit.helpbuy.service.HelpBuyService
import javax.inject.Inject


class HelpBuyReqPresenter @Inject constructor() :BasePresenter<HelpBuyReqView>(){
    @Inject
    lateinit var helpBuyService: HelpBuyService

    fun addHelpRequest(commitHelpBuyOrderReq: CommitHelpBuyOrderReq){
        helpBuyService.addHelpRequest(commitHelpBuyOrderReq).execute(object :BaseSubscriber<Boolean>(mView){
            override fun onNext(t: Boolean) {
                if (t){
                    mView.onCommitSuccess()
                }else{
                    mView.onCommitError()
                }
            }


            override fun onError(e: Throwable?) {
                mView.onCommitError()
            }
        },lifeCycleProvider)
    }





}