package com.itaem.serpit.order.ui.fragment


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.launcher.ARouter
import com.example.baselibrary.ui.fragment.BaseMvpFragment
import com.itaem.serpit.baselibrary.common.BaseConstant

import com.itaem.serpit.mvpservicemarket.order.R


import com.itaem.serpit.order.data.protocol.ShopInfo
import com.itaem.serpit.order.injection.component.DaggerOrderFragmentComponent
import com.itaem.serpit.order.injection.module.OrderModule
import com.itaem.serpit.order.presenter.MainFragmentPresenter
import com.itaem.serpit.order.presenter.view.ShopListView
import com.itaem.serpit.order.ui.activity.ShopDetailActivity
import com.itaem.serpit.order.ui.adapter.ShopListAdapter
import com.kotlin.base.ui.adapter.BaseRecyclerViewAdapter
import com.kotlin.base.utils.AppPrefsUtils
import kotlinx.android.synthetic.main.fragment_main.*
import org.jetbrains.anko.support.v4.toast


/**
 * 首页
 */
class MainFragment : BaseMvpFragment<MainFragmentPresenter>(),ShopListView, View.OnClickListener {
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.mSortGL->{
                toast("分类查看功能暂未开通，敬请请期待")
            }
            R.id.mIIv->{
                ARouter.getInstance().build("/userCenter/IActivity").navigation()
            }
            R.id.mSearchCv->{
                toast("搜索功能暂未开通，敬请请期待")
            }
        }
    }

    private lateinit var adapter: ShopListAdapter



    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        loadData()

        return inflater?.inflate(R.layout.fragment_main,null)
    }

    override fun onResume() {
        super.onResume()
        initView()
    }
    private fun initView() {
        mSortGL.setOnClickListener(this)
        mSearchCv.setOnClickListener(this)
        mIIv.setOnClickListener(this)
        if (AppPrefsUtils.getString(BaseConstant.KEY_SP_LOCATION)!=""){
            mLocationTv.text = AppPrefsUtils.getString(BaseConstant.KEY_SP_LOCATION)
        }
    }

    private fun loadData() {
        adapter = ShopListAdapter(activity)
        //showLoading()
        mPresenter.getShopsList(1)
    }


    override fun onGetShopsListFailed() {
        toast("获取商家列表失败，服务器异常")
    }

    override fun onGetShopsListResult(list: List<ShopInfo>) {

        adapter.setOnItemClickListener(object : BaseRecyclerViewAdapter.OnItemClickListener<ShopInfo>{
            override fun onItemClick(item: ShopInfo, position: Int) {
                val intent = Intent(activity,ShopDetailActivity::class.java)
                intent.putExtra("ShopInfo",item)
                startActivity(intent)
            }
        })
        adapter.setData(list)
        mShopListRv.adapter = adapter
    }

    override fun injectComponent() {
        DaggerOrderFragmentComponent.builder().fragmentComponent(fragmentComponent).orderModule(OrderModule()).build().inject(this)
        mPresenter.mView = this
    }
}