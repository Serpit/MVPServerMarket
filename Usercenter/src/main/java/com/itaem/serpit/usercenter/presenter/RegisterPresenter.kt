package com.itaem.serpit.usercenter.presenter

import com.example.baselibrary.presenter.view.BasePresenter
import com.example.baselibrary.rx.BaseSubscriber
import com.itaem.serpit.baselibrary.ext.execute
import com.itaem.serpit.usercenter.presenter.view.RegisterView
import com.itaem.serpit.usercenter.service.UserService
import javax.inject.Inject


class RegisterPresenter @Inject constructor() :BasePresenter<RegisterView>(){
    @Inject
    lateinit var userService : UserService
        fun register(user:String, password:String, address:String, phone:String){
            if (!checkNetWork()){
                return
            }
            mView.showLoading()
            userService.register(user,password,address,phone).execute(object :BaseSubscriber<String>(mView){
                override fun onNext(t: String) {
                   mView.registerResult(t)
                }
            },lifeCycleProvider)



        }
}