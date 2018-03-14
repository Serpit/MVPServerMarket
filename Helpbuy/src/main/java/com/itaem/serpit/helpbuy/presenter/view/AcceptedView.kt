package com.itaem.serpit.helpbuy.presenter.view

import com.itaem.serpit.baselibrary.presenter.view.BaseView
import com.itaem.serpit.helpbuy.data.protocol.AcceptedOrderResp
import com.itaem.serpit.helpbuy.data.protocol.Data
import com.itaem.serpit.helpbuy.data.protocol.HelperTable


/**
 * 已接受的View层
 */
interface AcceptedView : BaseView {
    fun onGetMyAcceptedResult( List: List<Data>)
    fun onDeleteAcceptedOrderSuccess()
    fun onDeleteAcceptedOrderFailed()
}