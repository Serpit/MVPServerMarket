package com.itaem.serpit.helpbuy.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.baselibrary.ui.activity.BaseMvpActivity
import com.itaem.serpit.baselibrary.common.BaseConstant
import com.itaem.serpit.helpbuy.injection.component.DaggerHelpBuyComponent
import com.itaem.serpit.helpbuy.injection.module.HelpBuyModule
import com.itaem.serpit.helpbuy.presenter.HelpBuyMsgPresenter
import com.itaem.serpit.helpbuy.presenter.view.HelpBuyMsgView
import com.itaem.serpit.mvpservicemarket.helpbuy.R


import com.kotlin.base.utils.AppPrefsUtils


import kotlinx.android.synthetic.main.activity_help_buy_msg.*

import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast


/*代购信息*/
@Route(path = "/HelpBuy/HelpBuyMsgActivity")
class HelpBuyMsgActivity : BaseMvpActivity<HelpBuyMsgPresenter>(), HelpBuyMsgView, View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help_buy_msg)

        initView()

    }

    private fun initView() {
        loadData()
        mShowHelpBuyReqLL.setOnClickListener(this)
        mEvaluationLL.setOnClickListener(this)
        mExitIv.setOnClickListener(this)

    }

    private fun loadData() {
        mUserNameTv.text = AppPrefsUtils.getString(BaseConstant.KEY_SP_USERNAME)
        mPhoneTv.text = AppPrefsUtils.getString(BaseConstant.KEY_SP_PHONE)
    }


    override fun injectComponent() {
        DaggerHelpBuyComponent.builder().activityComponent(activityComponent).helpBuyModule(HelpBuyModule()).build().inject(this)
        mPresenter.mView = this
    }


    override fun onClick(v: View?) {
        when(v?.id){
            R.id.mShowHelpBuyReqLL -> {
                startActivity<RequestDetailActivity>()
            }
            R.id.mExitIv->{finish()}
            R.id.mEvaluationLL ->{toast("该功能尚未开通!敬请期待")}
        }
    }



}
