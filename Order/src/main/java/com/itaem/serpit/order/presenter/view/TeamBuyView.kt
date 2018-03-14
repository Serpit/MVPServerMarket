package com.itaem.serpit.order.presenter.view

import com.itaem.serpit.baselibrary.presenter.view.BaseView
import com.itaem.serpit.order.data.bean.TeamBuyItem


/**
 *
 */
interface TeamBuyView : BaseView {
    fun onGetTeamBuyListSuccess(list:ArrayList<TeamBuyItem>)
    fun onGetTeamBuyListFailed()
    fun onJoinTeamBuySuccess()
    fun onJoinTeamBuyFailed()
}