package com.itaem.serpit.order.presenter.view

import com.itaem.serpit.baselibrary.presenter.view.BaseView


/**
 *
 */
interface SettlementView : BaseView {

    fun onPostOrderSuccess()
    fun onPostOrderFail()
}