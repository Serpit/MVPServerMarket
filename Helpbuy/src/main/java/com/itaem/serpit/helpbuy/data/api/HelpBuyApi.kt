package com.itaem.serpit.helpbuy.data.api

import com.itaem.serpit.baselibrary.data.protocol.BaseResp
import com.itaem.serpit.helpbuy.data.protocol.*
import retrofit2.http.*

import rx.Observable

/**
 * Created by Administrator on 2018/2/15 0015.
 */
interface HelpBuyApi {
    @GET("/serviceMarket-manager-web/GET/getAllHelperTable")
    fun getAllHelperTable(@Query("page") page:Int, @Query("rows") rows:Int):Observable<HelpBuyRequestInfo>

    @POST("/serviceMarket-manager-web/POST/acceptRequest")
    fun acceptRequest(@Body req:AcceptOrderReq):Observable<BaseResp<Boolean>>

    @GET("/serviceMarket-manager-web/GET/getMyHelperTable/{userId}")
    fun getMyHelperTable(@Path("userId") userId:Int):Observable<BaseResp<List<HelperTable>>>

    @GET("/serviceMarket-manager-web/GET/getMyAccept/{helperId}")
    fun getMyAccept(@Path("helperId") helperId:Int):Observable<AcceptedOrderResp>

    @DELETE("/serviceMarket-manager-web/DELETE/deleteAccept/{helperAcceptId}")
    fun deleteAccept(@Path("helperAcceptId")  helperAcceptId:Int):Observable<BaseResp<Boolean>>

    @POST("/serviceMarket-manager-web/POST/addHelpRequest")
    fun addHelpRequest(@Body commitHelpBuyOrderReq: CommitHelpBuyOrderReq):Observable<BaseResp<Boolean>>
    @PUT("/serviceMarket-manager-web/PUT/agreeHelper/{helpTableId}/{acceptId}")
    fun agreeHelper(@Path("helpTableId")helperTableId:Int,@Path("acceptId")acceptId:Int):Observable<BaseResp<Boolean>>
}