package com.itaem.serpit.order.presenter.view

import com.itaem.serpit.baselibrary.presenter.view.BaseView
import com.itaem.serpit.order.data.bean.TeamBuyItem


/**
 *
 */
interface MyTeamView : BaseView {
    fun onGetListSuccess(list:List<TeamBuyItem>)
    fun onGetListFailed()
}