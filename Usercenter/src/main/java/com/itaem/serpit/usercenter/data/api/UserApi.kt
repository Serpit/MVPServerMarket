package com.itaem.serpit.usercenter.data.api

import com.itaem.serpit.baselibrary.data.protocol.BaseResp
import com.itaem.serpit.usercenter.data.protocol.*
import okhttp3.MultipartBody
import retrofit2.http.*
import rx.Observable

/**
 * Created by Administrator on 2018/2/7 0007.
 */
interface UserApi {
    @POST("/serviceMarket-manager-web/POST/register")
    fun register(@Body req: RegisterReq):Observable<BaseResp<String>>

    @POST("/serviceMarket-manager-web/GET/userInfo")
    fun login(@Body req: LoginReq):Observable<BaseResp<UserInfo>>
    @PUT("/serviceMarket-manager-web/PUT/helperRegister/{userId}")
    fun toBeHelper(@Path("userId") req: Int):Observable<BaseResp<Boolean>>
    @PUT("/serviceMarket-manager-web/PUT/insertShop")
    fun toBeShoper(@Body toBeShoperReq: RegisterShoperReq) :Observable<BaseResp<Boolean>>



    @Multipart
    @POST("/serviceMarket-manager-web/POST/updImage/{userId}")
    fun postUserImage(@Path("userId") userId:Int,@Part part:MultipartBody.Part):Observable<UploadImgResp>
    @Multipart
    @POST("/serviceMarket-manager-web/POST/updateShopImage/{shopId}")
    fun postShopImage(@Path("shopId") shopId:Int,@Part part:MultipartBody.Part):Observable<UploadImgResp>


}