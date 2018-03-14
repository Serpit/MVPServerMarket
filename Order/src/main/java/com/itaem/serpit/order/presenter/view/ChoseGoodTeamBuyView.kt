package com.itaem.serpit.order.presenter.view

import com.itaem.serpit.baselibrary.presenter.view.BaseView
import com.itaem.serpit.order.data.protocol.ShopDetail


/**
 *添加团购的View
 */
interface ChoseGoodTeamBuyView : BaseView {
    fun onGetListSuccess(list: List<ShopDetail.DataBean.GoodListBean>)
    fun onGetListFailed()
}