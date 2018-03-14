package com.itaem.serpit.order.ui.activity

import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.baselibrary.ui.activity.BaseMvpActivity
import com.itaem.serpit.mvpservicemarket.order.R
import com.itaem.serpit.order.data.bean.TeamBuyItem
import com.itaem.serpit.order.injection.component.DaggerOrderComponent
import com.itaem.serpit.order.injection.module.OrderModule
import com.itaem.serpit.order.presenter.MyTeamBuyPresenter
import com.itaem.serpit.order.presenter.view.MyTeamView
import com.itaem.serpit.order.ui.adapter.MyTeamBuyListAdapter
import kotlinx.android.synthetic.main.activity_my_team_buy.*
import org.jetbrains.anko.toast


/*我的团购页面*/
@Route(path = "/Order/MyTeamBuyActivity")
class MyTeamBuyActivity : BaseMvpActivity<MyTeamBuyPresenter>(), MyTeamView {

    lateinit var adapter:MyTeamBuyListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_team_buy)
        loadData()
    }

    private fun loadData() {
        mPresenter.loadMyTeamBuy()
    }




    override fun onGetListSuccess(list:List<TeamBuyItem>) {
        mTipsTv.visibility = View.GONE
        adapter = MyTeamBuyListAdapter(this)
        adapter.setData(list)
        mListRv.adapter = adapter
    }

    override fun onGetListFailed() {
        toast("获取列表失败，请稍后重试")
    }

    override fun injectComponent() {
        DaggerOrderComponent.builder().activityComponent(activityComponent).orderModule(OrderModule()).build().inject(this)
        mPresenter.mView = this
    }






}
