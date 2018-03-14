package com.itaem.serpit.order.presenter

import com.example.baselibrary.presenter.view.BasePresenter
import com.example.baselibrary.rx.BaseSubscriber
import com.itaem.serpit.baselibrary.common.BaseConstant
import com.itaem.serpit.baselibrary.ext.execute
import com.itaem.serpit.order.data.bean.TeamBuyItem
import com.itaem.serpit.order.data.protocol.TeamBuyInfo
import com.itaem.serpit.order.presenter.view.MyTeamView
import com.itaem.serpit.order.service.OrderService
import com.kotlin.base.utils.AppPrefsUtils
import javax.inject.Inject

/*
* 我的商店的P层
* */
class MyTeamBuyPresenter @Inject constructor() :BasePresenter<MyTeamView>(){
    @Inject
    lateinit var mService: OrderService

    /*查看我参加的团购*/
    fun loadMyTeamBuy(){
         mView.showLoading()
         mService.getMyGrouping(AppPrefsUtils.getInt(BaseConstant.KEY_SP_USERID)).execute(object :BaseSubscriber<List<TeamBuyInfo>>(mView){
             override fun onNext(t: List<TeamBuyInfo>) {
                 val teamBuyItemList:ArrayList<TeamBuyItem> = arrayListOf()
                 for (teamBuyInfo in t){
                     val nameBuilder = StringBuilder()
                     for (good in teamBuyInfo.goodVo){
                         nameBuilder.append(good.name)
                         nameBuilder.append(" ")
                     }

                     teamBuyItemList.add(TeamBuyItem(teamBuyInfo.id,nameBuilder.toString(),teamBuyInfo.shopVo.pic,teamBuyInfo.endTime,teamBuyInfo.originalPrice,teamBuyInfo.groupPrice,teamBuyInfo.originalPrice,teamBuyInfo.limitNum))
                 }
                 mView.onGetListSuccess(teamBuyItemList)
             }

             override fun onError(e: Throwable?) {
                    mView.hideLoading()
                    mView.onGetListFailed()
             }
         },lifeCycleProvider)
    }



}
