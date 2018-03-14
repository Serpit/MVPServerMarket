package com.itaem.serpit.usercenter.data.repository


import com.itaem.serpit.baselibrary.data.net.RetrofitFactory
import com.itaem.serpit.baselibrary.data.protocol.BaseResp
import com.itaem.serpit.usercenter.data.api.UserApi
import com.itaem.serpit.usercenter.data.protocol.*
import okhttp3.MultipartBody
import rx.Observable
import javax.inject.Inject

/**
 * Created by Administrator on 2018/2/7 0007.
 */
class UserRepository @Inject constructor(){
    fun register(user:String, password:String, address:String, phone:String):Observable<BaseResp<String>>{
        return RetrofitFactory.instance.create(UserApi::class.java).register(RegisterReq(user,password,address,phone))
    }
    fun login(count:String,password: String):Observable<BaseResp<UserInfo>>{
        return RetrofitFactory.instance.create(UserApi::class.java).login(LoginReq(count,password))
    }
    fun toBeHelper(userId:Int):Observable<BaseResp<Boolean>>{
        return RetrofitFactory.instance.create(UserApi::class.java).toBeHelper(userId)
    }

    fun toBeShoper(toBeShoperReq: RegisterShoperReq):Observable<BaseResp<Boolean>>{
        return RetrofitFactory.instance.create(UserApi::class.java).toBeShoper(toBeShoperReq)
    }

     fun postShopImg(shopId: Int, part: MultipartBody.Part): Observable<UploadImgResp> {
        return RetrofitFactory.instance.create(UserApi::class.java).postShopImage(shopId,part)
    }

    fun postUserImg(userId: Int, part: MultipartBody.Part): Observable<UploadImgResp> {
        return RetrofitFactory.instance.create(UserApi::class.java).postUserImage(userId,part)
    }
}