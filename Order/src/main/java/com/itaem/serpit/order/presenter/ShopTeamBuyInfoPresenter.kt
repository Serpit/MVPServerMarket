package com.itaem.serpit.order.presenter

import android.util.Log
import com.example.baselibrary.presenter.view.BasePresenter
import com.example.baselibrary.rx.BaseSubscriber
import com.itaem.serpit.baselibrary.common.BaseConstant
import com.itaem.serpit.baselibrary.ext.execute
import com.itaem.serpit.order.data.bean.TeamBuyItem
import com.itaem.serpit.order.data.protocol.TeamBuyInfo
import com.itaem.serpit.order.presenter.view.ShopTeamBuyInfoView
import com.itaem.serpit.order.service.OrderService
import com.kotlin.base.utils.AppPrefsUtils
import javax.inject.Inject

/*
* 我的商店里团购情况的P
* */
class ShopTeamBuyInfoPresenter @Inject constructor() :BasePresenter<ShopTeamBuyInfoView>(){
    @Inject
    lateinit var mService: OrderService

    /*查看商店详情*/
    fun getGroups(){
        if (!checkNetWork()){
            return
        }
         mView.showLoading()
         mService.getGroupsByshopId(AppPrefsUtils.getInt(BaseConstant.KEY_SP_SHOP_ID)).execute(object :BaseSubscriber<List<TeamBuyInfo>>(mView){
             override fun onNext(t: List<TeamBuyInfo>) {
                 val teamBuyItemList:ArrayList<TeamBuyItem> = arrayListOf()
                 for (teamBuyInfo in t){
                     val nameBuilder = StringBuilder()
                     for (good in teamBuyInfo.goodVo){
                         if (good.num>0){
                             nameBuilder.append(good.name+" X "+good.num)
                             nameBuilder.append(" ")
                         }

                     }

                     teamBuyItemList.add(TeamBuyItem(teamBuyInfo.id,nameBuilder.toString(),AppPrefsUtils.getString(BaseConstant.KEY_SP_SHOP_LOGO),teamBuyInfo.endTime,teamBuyInfo.originalPrice,teamBuyInfo.groupPrice,teamBuyInfo.originalPrice,teamBuyInfo.limitNum))
                 }
                 mView.onGetListSuccess(teamBuyItemList)
             }

             override fun onError(e: Throwable?) {
                 Log.e("ERROR-",e.toString())
                 mView.hideLoading()
                 mView.onGetListFailed()
             }
         },lifeCycleProvider)
    }



}
