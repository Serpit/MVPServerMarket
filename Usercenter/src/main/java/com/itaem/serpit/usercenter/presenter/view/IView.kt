package com.itaem.serpit.usercenter.presenter.view

import com.itaem.serpit.baselibrary.presenter.view.BaseView

/**
 * Created by Administrator on 2018/2/7 0007.
 */
interface IView : BaseView {
    fun onToBeHelperResult(t:Boolean)
    fun onLogout()
    fun uploadImgSuccess(url:String)
    fun uploadImgFailed()
}