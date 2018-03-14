package com.itaem.serpit.usercenter.service.impl

import com.itaem.serpit.baselibrary.ext.convert
import com.itaem.serpit.baselibrary.ext.convertBoolean
import com.itaem.serpit.usercenter.data.protocol.RegisterShoperReq
import com.itaem.serpit.usercenter.data.protocol.UploadImgResp
import com.itaem.serpit.usercenter.data.protocol.UserInfo
import com.itaem.serpit.usercenter.data.repository.UserRepository
import com.itaem.serpit.usercenter.service.UserService
import okhttp3.MultipartBody
import rx.Observable
import javax.inject.Inject

/**
 * Created by Administrator on 2018/2/7 0007.
 */
class UserServiceImpl @Inject constructor():UserService {

    @Inject
    lateinit var repository : UserRepository

    override fun register(user: String, password: String, address: String, phone: String): Observable<String> {
        return repository.register(user,password,address,phone).convert()
    }

    override fun login(count: String, password: String): Observable<UserInfo> {
        return repository.login(count,password).convert()
    }
    override fun toBeHelper(userId: Int): Observable<Boolean> {
        return repository.toBeHelper(userId).convertBoolean()
    }

    override fun toBeShoper(toBeShoperReq: RegisterShoperReq): Observable<Boolean> {
        return repository.toBeShoper(toBeShoperReq).convertBoolean()
    }

    override fun postShopImg(shopId: Int, part: MultipartBody.Part): Observable<UploadImgResp> {
        return repository.postShopImg(shopId,part)
    }
    override fun postUserImg(userId: Int, part: MultipartBody.Part): Observable<UploadImgResp> {
        return repository.postShopImg(userId,part)
    }
}