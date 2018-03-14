package com.itaem.serpit.helpbuy.service

import com.itaem.serpit.helpbuy.data.protocol.*

import rx.Observable

/**
 * Created by Administrator on 2018/2/14 0014.
 */
interface HelpBuyService{

    fun getAllHelperTable( page:Int, rows:Int):Observable<HelpBuyRequestInfo>
    fun acceptRequest(acceptOrderReq: AcceptOrderReq):Observable<Boolean>
    fun getMyHelperTable(helperId:Int):Observable<AcceptedOrderResp>
    fun deleteAccept(helperAcceptId:Int):Observable<Boolean>
    fun addHelpRequest(commitHelpBuyOrderReq: CommitHelpBuyOrderReq):Observable<Boolean>
    fun getMyHelpBuyTable(userId:Int):Observable<List<HelperTable>>
    fun agreeHelper(helperTableId:Int,acceptId:Int):Observable<Boolean>
}