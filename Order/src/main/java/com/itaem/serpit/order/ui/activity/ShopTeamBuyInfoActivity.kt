package com.itaem.serpit.order.ui.activity

import android.os.Bundle
import android.view.View
import com.example.baselibrary.ui.activity.BaseMvpActivity
import com.itaem.serpit.mvpservicemarket.order.R
import com.itaem.serpit.order.data.bean.TeamBuyItem
import com.itaem.serpit.order.injection.component.DaggerOrderComponent
import com.itaem.serpit.order.injection.module.OrderModule
import com.itaem.serpit.order.presenter.ShopTeamBuyInfoPresenter
import com.itaem.serpit.order.presenter.view.ShopTeamBuyInfoView
import com.itaem.serpit.order.ui.adapter.ShoperGroupListAdapter
import kotlinx.android.synthetic.main.activity_shop_team_buy_info.*
import org.jetbrains.anko.startActivity


/*商店团购情况页面*/

class ShopTeamBuyInfoActivity : BaseMvpActivity<ShopTeamBuyInfoPresenter>(), ShopTeamBuyInfoView, View.OnClickListener {
    lateinit var adapter:ShoperGroupListAdapter
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.mAddGroupRv->{
                startActivity<ChoseGoodActivity>()
            }
        }
    }


    override fun onGetListSuccess(list: List<TeamBuyItem>) {
        mTipsTv.visibility = View.GONE
        adapter = ShoperGroupListAdapter(this)
        mListRv.adapter = adapter

        adapter.setData(list)
    }

    override fun onGetListFailed() {
        mTipsTv.visibility = View.VISIBLE

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_team_buy_info)
        initView()

    }

    override fun onResume() {
        super.onResume()
        loadData()
    }
    private fun initView() {
        mAddGroupRv.setOnClickListener(this)
    }

    private fun loadData() {
        mPresenter.getGroups()
    }






    override fun injectComponent() {
        DaggerOrderComponent.builder().activityComponent(activityComponent).orderModule(OrderModule()).build().inject(this)
        mPresenter.mView = this
    }






}
