package com.itaem.serpit.order.presenter.view

import com.itaem.serpit.baselibrary.presenter.view.BaseView
import com.itaem.serpit.order.data.protocol.GetMyShopInfoResp


/**
 *
 */
interface MyShopView : BaseView {

    fun onGetMyShopInfoSuccess(result:GetMyShopInfoResp)
    fun onGetMyShopInfoFailed()
}