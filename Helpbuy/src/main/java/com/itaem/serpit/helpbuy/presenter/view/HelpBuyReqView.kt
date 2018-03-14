package com.itaem.serpit.helpbuy.presenter.view

import com.itaem.serpit.baselibrary.presenter.view.BaseView
import com.itaem.serpit.helpbuy.data.protocol.AcceptedOrderResp


/**
 * 发布代购的View层
 */
interface HelpBuyReqView : BaseView {

    fun onCommitSuccess()
    fun onCommitError()

}