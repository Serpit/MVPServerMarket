package com.itaem.serpit.helpbuy.presenter.view

import com.itaem.serpit.baselibrary.presenter.view.BaseView
import com.itaem.serpit.helpbuy.data.protocol.HelpBuyRequestInfo


/**
 * 新请求的View层
 */
interface NewReqView : BaseView {
    fun onGetAllHelperTableResult(result: HelpBuyRequestInfo)
    fun onAcceptOrderSuccess()
    fun onAcceptOrderFailed()
}