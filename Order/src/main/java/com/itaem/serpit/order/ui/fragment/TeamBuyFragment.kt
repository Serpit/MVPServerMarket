package com.itaem.serpit.order.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.launcher.ARouter
import com.example.baselibrary.ui.fragment.BaseMvpFragment
import com.itaem.serpit.baselibrary.common.BaseConstant
import com.itaem.serpit.mvpservicemarket.order.R
import com.itaem.serpit.order.data.bean.TeamBuyItem
import com.itaem.serpit.order.injection.component.DaggerOrderFragmentComponent
import com.itaem.serpit.order.injection.module.OrderModule
import com.itaem.serpit.order.presenter.TeamBuyPresenter
import com.itaem.serpit.order.presenter.view.TeamBuyView
import com.itaem.serpit.order.ui.adapter.TeamBuyListAdapter
import com.kotlin.base.utils.AppPrefsUtils
import kotlinx.android.synthetic.main.fragment_team_buy.*
import org.jetbrains.anko.support.v4.toast


/**
 * 团购
 *
 */
class TeamBuyFragment :BaseMvpFragment<TeamBuyPresenter>(),TeamBuyView, View.OnClickListener {
    val TAG = "TeamBuyFragment"
    lateinit var adapter:TeamBuyListAdapter
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.mIIv->{
                ARouter.getInstance().build("/userCenter/IActivity").navigation()
            }

        }
    }




    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         super.onCreateView(inflater, container, savedInstanceState)

         return inflater?.inflate(R.layout.fragment_team_buy,null)
    }


    /*override fun onStart() {
        super.onStart()
        loadData()
        adapter = TeamBuyListAdapter(mPresenter,activity)
        initView()
    }*/


    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (hidden){
            Log.d(TAG,"隐藏")
        }else{
            Log.d(TAG,"显示")
            loadData()
            adapter = TeamBuyListAdapter(mPresenter,activity)
            // Log.d(TAG,"onResume")
            initView()
        }
    }


   /* override fun onResume() {
        super.onResume()
        loadData()
        adapter = TeamBuyListAdapter(mPresenter,activity)
       // Log.d(TAG,"onResume")
        initView()

    }*/

    private fun initView() {
        if (AppPrefsUtils.getString(BaseConstant.KEY_SP_LOCATION)!=""){
            mLocationTv.text = AppPrefsUtils.getString(BaseConstant.KEY_SP_LOCATION)
        }
        mIIv.setOnClickListener(this)
        mList.adapter = adapter
    }


    private fun loadData() {
        mPresenter.getMarketGrouping(1)
    }


    override fun onJoinTeamBuySuccess() {
        loadData()
        adapter = TeamBuyListAdapter(mPresenter,activity)
        initView()
        toast("参加团购成功")
    }

    override fun onJoinTeamBuyFailed() {
        toast("参加团购失败")
    }

    override fun onGetTeamBuyListSuccess(list: ArrayList<TeamBuyItem>) {

        adapter.setData(list)
    }

    override fun onGetTeamBuyListFailed() {
        toast("获取团购列表失败，服务器异常")
    }

    override fun injectComponent() {
        DaggerOrderFragmentComponent.builder().fragmentComponent(fragmentComponent).orderModule(OrderModule()).build().inject(this)
        mPresenter.mView = this
    }
}