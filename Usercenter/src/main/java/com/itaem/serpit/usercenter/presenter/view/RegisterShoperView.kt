package com.itaem.serpit.usercenter.presenter.view

import com.itaem.serpit.baselibrary.presenter.view.BaseView

/**
 * Created by Administrator on 2018/2/7 0007.
 */
interface RegisterShoperView : BaseView {
    fun onToBeShoperSuccess()
    fun onToBeShoperFail()
    fun onUploadImgSuccess(url:String)
}