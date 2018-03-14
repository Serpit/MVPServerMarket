package com.itaem.serpit.usercenter.presenter

import android.util.Log
import com.example.baselibrary.presenter.view.BasePresenter
import com.example.baselibrary.rx.BaseSubscriber
import com.itaem.serpit.baselibrary.common.BaseConstant
import com.itaem.serpit.baselibrary.ext.execute
import com.itaem.serpit.usercenter.data.protocol.UploadImgResp
import com.itaem.serpit.usercenter.presenter.view.IView
import com.itaem.serpit.usercenter.service.UserService
import com.kotlin.base.utils.AppPrefsUtils
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import javax.inject.Inject


class IPresenter @Inject constructor() :BasePresenter<IView>(){
    @Inject
    lateinit var userService : UserService
        fun toBeHelper(userId:Int){
            if (!checkNetWork()){
                return
            }
            mView.showLoading()
            userService.toBeHelper(userId).execute(object :BaseSubscriber<Boolean>(mView){
                override fun onNext(t:Boolean) {
                    mView.onToBeHelperResult(t)
                }

            },lifeCycleProvider)
        }

    fun uploadImg(img: File){
        if (!checkNetWork()){
            return
        }
        val request = RequestBody.create(MediaType.parse("multipart/form-data"),img)
        val requestBody = MultipartBody.Part.createFormData("uploadFile",img.name,request)
        mView.showLoading()
        userService.postUserImg(AppPrefsUtils.getInt(BaseConstant.KEY_SP_USERID),requestBody).execute(object :BaseSubscriber<UploadImgResp>(mView){
            override fun onNext(t:UploadImgResp) {
                AppPrefsUtils.putString(BaseConstant.KEY_SP_USER_IMG,t.url)
                Log.d("URL",t.url)
                mView.uploadImgSuccess(t.url)
            }

            override fun onError(e: Throwable?) {
                super.onError(e)
                mView.uploadImgFailed()
            }
        },lifeCycleProvider)
    }
    fun logout(){
        if (!checkNetWork()){
            return
        }

             AppPrefsUtils.putBoolean(BaseConstant.KEY_SP_SHOPPER,false)
            AppPrefsUtils.putBoolean(BaseConstant.KEY_SP_IS_LOGIN,false)
            AppPrefsUtils.putInt(BaseConstant.KEY_SP_USERID, 0)
            AppPrefsUtils.putString(BaseConstant.KEY_SP_PHONE, "")
            AppPrefsUtils.putString(BaseConstant.KEY_SP_PICTURE, "")
            AppPrefsUtils.putBoolean(BaseConstant.KEY_SP_HELPER, false)
            AppPrefsUtils.putBoolean(BaseConstant.KEY_SP_SHOPPER, false)
            AppPrefsUtils.putString(BaseConstant.SERVER_ADDRESS, "")
            AppPrefsUtils.putString(BaseConstant.KEY_SP_USERNAME,"")
            mView.onLogout()

    }
}