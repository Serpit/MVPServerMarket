package com.itaem.serpit.usercenter.service

import com.itaem.serpit.usercenter.data.protocol.RegisterShoperReq
import com.itaem.serpit.usercenter.data.protocol.UploadImgResp
import com.itaem.serpit.usercenter.data.protocol.UserInfo
import okhttp3.MultipartBody
import rx.Observable

/**
 * Created by Administrator on 2018/2/7 0007.
 */
interface UserService {
    fun register(user:String, password:String, address:String, phone:String):Observable<String>
    fun login(count:String,password: String):Observable<UserInfo>
    fun toBeHelper(userId:Int):Observable<Boolean>
    fun toBeShoper(toBeShoperReq: RegisterShoperReq):Observable<Boolean>
    fun postShopImg( shopId:Int, part: MultipartBody.Part):Observable<UploadImgResp>
    fun postUserImg( userId:Int, part: MultipartBody.Part):Observable<UploadImgResp>
}