package com.itaem.serpit.order.presenter.view

import com.itaem.serpit.baselibrary.presenter.view.BaseView
import com.itaem.serpit.order.data.protocol.ShopDetail


/**
 *已上架的Fragment的View
 */
interface HaveBeenOnView : BaseView {

    fun onCommitSuccess()
    fun onCommitFail()
    fun onGetMyGoodResult(list: List<ShopDetail.DataBean.GoodListBean>)
    fun onEditSuccess()
    fun onEditFail()
}