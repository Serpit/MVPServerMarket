package com.itaem.serpit.order.presenter.view

import com.itaem.serpit.baselibrary.presenter.view.BaseView


/**
 *添加团购的View
 */
interface AddShopTeamBuyView : BaseView {
    fun onAddSuccess()
    fun onAddFailed()

}