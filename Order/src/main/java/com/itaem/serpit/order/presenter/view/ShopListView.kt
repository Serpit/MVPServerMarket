package com.itaem.serpit.order.presenter.view

import com.itaem.serpit.baselibrary.presenter.view.BaseView
import com.itaem.serpit.order.data.protocol.ShopInfo


/**
 *
 */
interface ShopListView : BaseView {
    fun onGetShopsListResult(list:List<ShopInfo>)
    fun onGetShopsListFailed()
}