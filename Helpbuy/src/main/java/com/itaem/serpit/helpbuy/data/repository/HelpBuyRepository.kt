package com.itaem.serpit.helpbuy.data.repository


import com.itaem.serpit.baselibrary.data.net.RetrofitFactory
import com.itaem.serpit.baselibrary.data.protocol.BaseResp
import com.itaem.serpit.helpbuy.data.api.HelpBuyApi
import com.itaem.serpit.helpbuy.data.protocol.*

import rx.Observable
import javax.inject.Inject

/**
 * Created by Administrator on 2018/2/15 0015.
 */
class HelpBuyRepository @Inject constructor() {
    fun getAllHelperTable( page:Int, rows:Int): Observable<HelpBuyRequestInfo>{
        return RetrofitFactory.instance.create(HelpBuyApi::class.java).getAllHelperTable(page, rows)
    }
    fun acceptRequest(req:AcceptOrderReq): Observable<BaseResp<Boolean>>{
        return RetrofitFactory.instance.create(HelpBuyApi::class.java).acceptRequest(req)
    }

    fun getMyAccept(helperId:Int):Observable<AcceptedOrderResp>{
        return RetrofitFactory.instance.create(HelpBuyApi::class.java).getMyAccept(helperId)
    }
    fun addHelpRequest(commitHelpBuyOrderReq: CommitHelpBuyOrderReq):Observable<BaseResp<Boolean>>{
        return RetrofitFactory.instance.create(HelpBuyApi::class.java).addHelpRequest(commitHelpBuyOrderReq)
    }
    fun deleteAccept(helperId: Int):Observable<BaseResp<Boolean>>{
        return RetrofitFactory.instance.create(HelpBuyApi::class.java).deleteAccept(helperId)
    }
    fun getMyHelperTable(userId:Int):Observable<BaseResp<List<HelperTable>>>{
        return RetrofitFactory.instance.create(HelpBuyApi::class.java).getMyHelperTable(userId)
    }
    fun agreeHelper(helperTableId:Int,acceptId:Int):Observable<BaseResp<Boolean>>{
        return RetrofitFactory.instance.create(HelpBuyApi::class.java).agreeHelper(helperTableId,acceptId)
    }
}