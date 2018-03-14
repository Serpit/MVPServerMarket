package com.itaem.serpit.helpbuy.presenter.view

import com.itaem.serpit.baselibrary.presenter.view.BaseView
import com.itaem.serpit.helpbuy.data.protocol.AcceptedOrderResp
import com.itaem.serpit.helpbuy.data.protocol.HelperTable


/**
 * 代购历史的View层
 */
interface HelpBuyFragmentView : BaseView {
    fun onGetListSuccess(list: List<HelperTable>)
    fun onGetListFailed()
    fun onAgreeSuccess()
    fun onAgreeFailed()
}