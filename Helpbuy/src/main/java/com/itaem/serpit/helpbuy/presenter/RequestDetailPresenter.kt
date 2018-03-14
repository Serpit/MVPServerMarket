package com.itaem.serpit.helpbuy.presenter

import android.util.Log
import com.example.baselibrary.presenter.view.BasePresenter
import com.example.baselibrary.rx.BaseSubscriber
import com.itaem.serpit.baselibrary.ext.execute
import com.itaem.serpit.helpbuy.presenter.view.RequestDetailView
import com.itaem.serpit.helpbuy.service.HelpBuyService
import javax.inject.Inject


class RequestDetailPresenter @Inject constructor() :BasePresenter<RequestDetailView>(){
    /*@Inject
    lateinit var helpBuyService: HelpBuyService
        fun toBeHelper(userId:Int){
            if (!checkNetWork()){
                return
            }
            mView.showLoading()
            helpBuyService.toBeHelper(userId).execute(object :BaseSubscriber<Boolean>(mView){
                override fun onNext(t:Boolean) {

                }

            },lifeCycleProvider)



        }*/
}