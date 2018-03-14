package com.itaem.serpit.usercenter.presenter


import android.util.Log
import com.example.baselibrary.presenter.view.BasePresenter
import com.example.baselibrary.rx.BaseSubscriber
import com.itaem.serpit.baselibrary.common.BaseConstant
import com.itaem.serpit.baselibrary.ext.execute
import com.itaem.serpit.usercenter.data.protocol.RegisterShoperReq
import com.itaem.serpit.usercenter.data.protocol.UploadImgResp
import com.itaem.serpit.usercenter.presenter.view.RegisterShoperView
import com.itaem.serpit.usercenter.service.UserService
import com.kotlin.base.utils.AppPrefsUtils
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import javax.inject.Inject


class RegisterShoperPresenter @Inject constructor() :BasePresenter<RegisterShoperView>(){
    @Inject
    lateinit var userService : UserService
        fun toBeShoper(toBeShoperReq: RegisterShoperReq){
            if (!checkNetWork()){
                return
            }
            mView.showLoading()
            userService.toBeShoper(toBeShoperReq).execute(object :BaseSubscriber<Boolean>(mView){
                override fun onNext(t: Boolean) {
                    if(t) {
                        AppPrefsUtils.putBoolean(BaseConstant.KEY_SP_SHOPPER,true)
                        mView.onToBeShoperSuccess()
                    }
                    else {mView.onToBeShoperFail()}

                }

                override fun onError(e: Throwable?) {
                    mView.onToBeShoperFail()
                }
            },lifeCycleProvider)

        }

    fun uploadImg(img: File,shopId:Int){
        if (!checkNetWork()){
            return
        }
        val request = RequestBody.create(MediaType.parse("multipart/form-data"),img)
        val requestBody = MultipartBody.Part.createFormData("uploadFile",img.name,request)
        mView.showLoading()
        userService.postShopImg(shopId,requestBody).execute(object :BaseSubscriber<UploadImgResp>(mView){
            override fun onNext(t: UploadImgResp) {
                Log.d("UPLOADURL",  t.url)
                AppPrefsUtils.putString(BaseConstant.KEY_SP_SHOP_LOGO,t.url)
                mView.onUploadImgSuccess(t.url)
            }
        },lifeCycleProvider)


    }
}