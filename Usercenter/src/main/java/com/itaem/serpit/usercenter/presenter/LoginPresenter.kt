package com.itaem.serpit.usercenter.presenter

import com.example.baselibrary.presenter.view.BasePresenter
import com.example.baselibrary.rx.BaseSubscriber
import com.itaem.serpit.baselibrary.common.BaseConstant
import com.itaem.serpit.baselibrary.ext.execute
import com.itaem.serpit.usercenter.data.protocol.UserInfo
import com.itaem.serpit.usercenter.presenter.view.LoginView
import com.itaem.serpit.usercenter.service.UserService
import com.kotlin.base.utils.AppPrefsUtils
import javax.inject.Inject


class LoginPresenter @Inject constructor() :BasePresenter<LoginView>(){
    @Inject
    lateinit var userService : UserService
        fun login(count:String, password:String){
            if (!checkNetWork()){
                return
            }
            mView.showLoading()
            userService.login(count,password).execute(object :BaseSubscriber<UserInfo>(mView){
                override fun onNext(t: UserInfo) {
                    saveUserInfo(t,count)
                    mView.login()
                }

                override fun onError(e: Throwable?) {
                    super.onError(e)
                    mView.loginError()
                }
            },lifeCycleProvider)



        }
        fun saveUserInfo(userInfo: UserInfo,count: String){
            AppPrefsUtils.putBoolean(BaseConstant.KEY_SP_IS_LOGIN,true)
            AppPrefsUtils.putString(BaseConstant.KEY_SP_TOKEN, userInfo.token)
            AppPrefsUtils.putInt(BaseConstant.KEY_SP_USERID, userInfo.userId)
            AppPrefsUtils.putString(BaseConstant.KEY_SP_PHONE, userInfo.phone)
            AppPrefsUtils.putString(BaseConstant.KEY_SP_PICTURE, userInfo.picture)
            AppPrefsUtils.putBoolean(BaseConstant.KEY_SP_HELPER, userInfo.helper)
            AppPrefsUtils.putBoolean(BaseConstant.KEY_SP_SHOPPER, userInfo.shopper)
            AppPrefsUtils.putString(BaseConstant.SERVER_ADDRESS, userInfo.address)
            AppPrefsUtils.putString(BaseConstant.KEY_SP_USERNAME,count)
        }

}