package com.itaem.serpit.order.presenter

import com.example.baselibrary.presenter.view.BasePresenter
import com.example.baselibrary.rx.BaseSubscriber
import com.itaem.serpit.baselibrary.common.BaseConstant
import com.itaem.serpit.baselibrary.ext.execute
import com.itaem.serpit.order.data.protocol.AddGoodReq
import com.itaem.serpit.order.data.protocol.EditGoodReq
import com.itaem.serpit.order.data.protocol.GetMyShopInfoResp
import com.itaem.serpit.order.presenter.view.HaveBeenOnView
import com.itaem.serpit.order.service.OrderService
import com.kotlin.base.utils.AppPrefsUtils
import javax.inject.Inject

/*
* 已上架的Fragment的P
* */
class HaveBeenOnPresenter @Inject constructor() :BasePresenter<HaveBeenOnView>(){
    @Inject
    lateinit var mService: OrderService

    /*查看商店详情*/
    fun addGood(addGoodReq: AddGoodReq){
        if (!checkNetWork()){
            return
        }
         mView.showLoading()
         mService.insertGood(addGoodReq).execute(object :BaseSubscriber<Boolean>(mView){
             override fun onNext(t: Boolean) {
                 if (t){
                     mView.onCommitSuccess()
                 }else{
                     mView.onCommitFail()
                 }
             }

             override fun onError(e: Throwable?) {
                 mView.onCommitFail()
             }
         },lifeCycleProvider)
    }
    /*查看商店详情*/
    fun loadShopInfo(){
        mView.showLoading()
        mService.getMyShopDetail(AppPrefsUtils.getInt(BaseConstant.KEY_SP_USERID)).execute(object :BaseSubscriber<GetMyShopInfoResp>(mView){
            override fun onNext(t: GetMyShopInfoResp) {
                mView.onGetMyGoodResult(t.goodList)

            }

            override fun onError(e: Throwable?) {

            }
        },lifeCycleProvider)
    }

    fun editGoodCommit(editGoodReq: EditGoodReq){
        mView.showLoading()
        mService.updateGood(editGoodReq).execute(object :BaseSubscriber<Boolean>(mView){
            override fun onNext(t: Boolean) {
                if (t){
                    mView.onEditSuccess()
                }else{
                    mView.onCommitFail()
                }
            }

            override fun onError(e: Throwable?) {
                mView.onEditFail()
            }
        },lifeCycleProvider)
    }


}
