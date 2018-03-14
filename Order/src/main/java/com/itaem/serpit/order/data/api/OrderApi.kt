package com.itaem.serpit.order.data.api

import com.itaem.serpit.baselibrary.data.protocol.BaseResp
import com.itaem.serpit.order.data.protocol.*
import okhttp3.MultipartBody
import retrofit2.http.*

import rx.Observable

/**
 * Created by Administrator on 2018/2/15 0015.
 */
interface OrderApi {
    @GET("/serviceMarket-manager-web/GET/shopList")
    fun getShopsList(@Query("marketId") marketId:Int):Observable<BaseResp<List<ShopInfo>>>

    @GET("/serviceMarket-manager-web/GET/shopDetail/{shopId}")
    fun getShopDetail(@Path("shopId") shopId:Int):Observable<ShopDetail>

    @POST("/serviceMarket-manager-web/POST/order")
    fun postOrder(@Body postOrderReq: PostOrderReq):Observable<BaseResp<Boolean>>

    @PATCH("/serviceMarket-manager-web/PATCH/acceptOrders/{userId}/{orderId")
    fun acceptOrder(@Path("userId") userId:Int,@Path("orderId") orderId:Int):Observable<BaseResp<Boolean>>

    @GET("/serviceMarket-manager-web/GET/getMyShopDetail/{userId}")
    fun getMyShopDetail(@Path("userId") userId:Int):Observable<BaseResp<GetMyShopInfoResp>>

    @POST("/serviceMarket-manager-web/POST/insertGood")
    fun insertGood(@Body addGoodReq: AddGoodReq):Observable<BaseResp<Boolean>>


    @PUT("/serviceMarket-manager-web/PUT/updateGood")
    fun updateGood(@Body editGoodReq: EditGoodReq):Observable<BaseResp<Boolean>>


    @GET("/serviceMarket-manager-web/Get/getMarketGrouping/{markId}")
    fun getMarketGrouping(@Path("markId") marketId: Int):Observable<BaseResp<List<TeamBuyInfo>>>

    @Multipart
    @POST("/serviceMarket-manager-web/POST/insertGoodPic/{shopId}")
    fun insertGoodPic(@Path("shopId") shopId: Int,@Part part: MultipartBody.Part):Observable<BaseResp<Boolean>>

    /*参加团购*/
    @POST("/serviceMarket-manager-web/POST/joinGroups")
    fun joinGroups(@Body joinGroupReq: JoinGroupReq):Observable<BaseResp<Boolean>>


    @GET("/serviceMarket-manager-web/ /Get/getGroupsByshopId/{shopId}")
    fun getGroupsByshopId(@Path("shopId") shopId: Int):Observable<BaseResp<List<TeamBuyInfo>>>


    @POST("/serviceMarket-manager-web/POST/Groups")
    fun groups(@Body groupReq:GroupReq):Observable<BaseResp<Boolean>>



    @GET("/serviceMarket-manager-web/Get/getMyGroups/{userId}")
    fun getMyGroups(@Path("userId") userId: Int):Observable<BaseResp<List<TeamBuyInfo>>>
}