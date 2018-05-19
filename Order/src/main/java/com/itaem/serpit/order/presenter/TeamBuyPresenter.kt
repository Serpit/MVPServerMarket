package com.itaem.serpit.order.presenter

import com.example.baselibrary.presenter.view.BasePresenter
import com.example.baselibrary.rx.BaseSubscriber
import com.itaem.serpit.baselibrary.ext.execute
import com.itaem.serpit.order.data.bean.TeamBuyItem
import com.itaem.serpit.order.data.protocol.JoinGroupReq
import com.itaem.serpit.order.data.protocol.TeamBuyInfo
import com.itaem.serpit.order.presenter.view.TeamBuyView
import com.itaem.serpit.order.service.OrderService
import javax.inject.Inject

/*
* 团购fragment的P层
* */
class TeamBuyPresenter @Inject constructor() :BasePresenter<TeamBuyView>(){
    @Inject
    lateinit var mService: OrderService

    /*查看团购列表*/
    fun getMarketGrouping(marketId:Int){
        if(!checkNetWork()){
            return
        }
         mView.showLoading()
         mService.getMarketGrouping(marketId).execute(object :BaseSubscriber<List<TeamBuyInfo>>(mView){
             override fun onNext(t: List<TeamBuyInfo>) {
                 val teamBuyItemList:ArrayList<TeamBuyItem> = arrayListOf()
                 for (teamBuyInfo in t){
                     if(teamBuyInfo.surplus<=0){
                         continue;
                     }
                     val nameBuilder = StringBuilder()
                     for (good in teamBuyInfo.goodVo){
                         if(good.num>0){
                             nameBuilder.append(good.name)
                             nameBuilder.append(" ")
                         }

                     }

                     teamBuyItemList.add(TeamBuyItem(teamBuyInfo.id,
                             nameBuilder.toString(),
                             teamBuyInfo.shopVo.pic,
                             teamBuyInfo.endTime,teamBuyInfo.originalPrice,
                             teamBuyInfo.groupPrice,
                             teamBuyInfo.surplus,
                             teamBuyInfo.limitNum))
                 }
                 mView.onGetTeamBuyListSuccess(teamBuyItemList)
             }

             override fun onError(e: Throwable?) {
                 mView.hideLoading()
                mView.onGetTeamBuyListFailed()
             }
         },lifeCycleProvider)
    }


    fun joinGroup(joinGroupReq: JoinGroupReq){
        if(!checkNetWork()){
            return
        }
        mView.showLoading()
        mService.joinGroups(joinGroupReq).execute(object :BaseSubscriber<Boolean>(mView){
            override fun onNext(t: Boolean) {
                if (t){
                    mView.onJoinTeamBuySuccess()
                }else{
                    mView.onJoinTeamBuyFailed()
                }
            }

            override fun onError(e: Throwable?) {
                mView.onJoinTeamBuyFailed()
                mView.hideLoading()

            }
        },lifeCycleProvider)
    }


}
