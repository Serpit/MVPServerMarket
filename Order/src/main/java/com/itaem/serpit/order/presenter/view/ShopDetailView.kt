package com.itaem.serpit.order.presenter.view

import com.itaem.serpit.baselibrary.presenter.view.BaseView
import com.itaem.serpit.order.data.protocol.ShopDetail

/**
 * Created by Administrator on 2018/2/24 0024.
 */
interface ShopDetailView :BaseView{
    fun onGetShopDetailResult(result: ShopDetail)
    fun onGetShopDetailFailed()
}