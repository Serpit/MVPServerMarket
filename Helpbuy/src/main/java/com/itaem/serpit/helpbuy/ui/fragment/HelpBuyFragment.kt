package com.itaem.serpit.helpbuy.ui.fragment

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.alibaba.android.arouter.launcher.ARouter
import com.example.baselibrary.ui.fragment.BaseMvpFragment
import com.itaem.serpit.baselibrary.common.BaseConstant
import com.itaem.serpit.baselibrary.ext.onClick
import com.itaem.serpit.helpbuy.data.protocol.AcceptedOrderResp
import com.itaem.serpit.helpbuy.data.protocol.HelperTable
import com.itaem.serpit.helpbuy.injection.component.DaggerHelpBuyFragmentComponent
import com.itaem.serpit.helpbuy.injection.module.HelpBuyModule
import com.itaem.serpit.helpbuy.presenter.AcceptedPresenter
import com.itaem.serpit.helpbuy.presenter.HelpBuyFragmentPresenter
import com.itaem.serpit.helpbuy.presenter.view.AcceptedView
import com.itaem.serpit.helpbuy.presenter.view.HelpBuyFragmentView
import com.itaem.serpit.helpbuy.ui.activity.HelpBuyMsgActivity
import com.itaem.serpit.helpbuy.ui.activity.HelpBuyReqActivity
import com.itaem.serpit.helpbuy.ui.adapter.AcceptedAdapter
import com.itaem.serpit.helpbuy.ui.adapter.HistoryListAdapter
import com.itaem.serpit.mvpservicemarket.helpbuy.R

import com.kotlin.base.ui.adapter.BaseRecyclerViewAdapter
import com.kotlin.base.utils.AppPrefsUtils
import kotlinx.android.synthetic.main.fragment_help_buy.*
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.toast


/**
 * 主界面的HelpBuyFragment
 */
class HelpBuyFragment :BaseMvpFragment<HelpBuyFragmentPresenter>(),HelpBuyFragmentView,View.OnClickListener, BaseRecyclerViewAdapter.OnItemClickListener<HelperTable> {


    lateinit var adapter:HistoryListAdapter
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)


        return inflater?.inflate(R.layout.fragment_help_buy,null)
    }

    private fun initView() {
        if (AppPrefsUtils.getString(BaseConstant.KEY_SP_LOCATION)!=""){
            mLocationTv.text = AppPrefsUtils.getString(BaseConstant.KEY_SP_LOCATION)
        }
        mIIv.setOnClickListener(this)
        mFabHelpBuy.onClick (this)
    }

    override fun onResume() {
        super.onResume()
        initView()
        loadData()
    }

    override fun onItemClick(item: HelperTable, position: Int) {
        if (item.state==2){
            val builder = AlertDialog.Builder(activity)

            builder.setPositiveButton("同意",object : DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {

                    mPresenter.agreeHelper(item.accepterVoList[0].helperTableId,item.accepterVoList[0].id)
                }
            }).setMessage("用户名：${item.accepterVoList[0].helperName}，电话${item.accepterVoList[0].phone}").setTitle("确定是否同意此代购者为您服务")
                    .setNegativeButton("不同意",null)
                    .show()
        }



    }
    override fun onAgreeSuccess() {
        toast("已同意此代购者接单")
    }

    override fun onAgreeFailed() {
        toast("同意此代购者接单失败，请稍后再试")
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.mFabHelpBuy->{
                startActivity<HelpBuyReqActivity>()
            }
            R.id.mIIv->{
               ARouter.getInstance().build("/userCenter/IActivity").navigation()
            }
        }
    }


    override fun onGetListSuccess(list: List<HelperTable>) {
        adapter = HistoryListAdapter(activity)
        adapter.setOnItemClickListener(this)
        mHelpBuyListRv.adapter = adapter
        adapter.setData(list)
    }

    override fun onGetListFailed() {
        toast("获取我的代购列表失败")
    }

    private fun loadData() {
        mPresenter.getMyHelpBuyTable()
    }



    override fun injectComponent() {
        DaggerHelpBuyFragmentComponent.builder().fragmentComponent(fragmentComponent).helpBuyModule(HelpBuyModule()).build().inject(this)
        mPresenter.mView = this
    }
}