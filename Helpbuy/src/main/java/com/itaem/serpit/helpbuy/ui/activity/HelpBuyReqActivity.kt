package com.itaem.serpit.helpbuy.ui.activity

import android.os.Bundle
import android.view.View
import com.example.baselibrary.ui.activity.BaseMvpActivity
import com.itaem.serpit.baselibrary.common.BaseConstant
import com.itaem.serpit.baselibrary.ext.onClick
import com.itaem.serpit.baselibrary.utils.DateUtils
import com.itaem.serpit.helpbuy.data.protocol.CommitHelpBuyOrderReq
import com.itaem.serpit.helpbuy.injection.component.DaggerHelpBuyComponent
import com.itaem.serpit.helpbuy.injection.module.HelpBuyModule
import com.itaem.serpit.helpbuy.presenter.HelpBuyReqPresenter

import com.itaem.serpit.helpbuy.presenter.view.HelpBuyReqView
import com.itaem.serpit.mvpservicemarket.helpbuy.R

import com.kotlin.base.utils.AppPrefsUtils
import kotlinx.android.synthetic.main.activity_help_buy_req.*
import org.jetbrains.anko.toast


/*发布代购*/

class HelpBuyReqActivity : BaseMvpActivity<HelpBuyReqPresenter>(), HelpBuyReqView, View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help_buy_req)

        initView()


    }

    private fun initView() {
        mHeaderBar.getRightView().onClick (this)
    }


    override fun injectComponent() {
        DaggerHelpBuyComponent.builder().activityComponent(activityComponent).helpBuyModule(HelpBuyModule()).build().inject(this)
        mPresenter.mView = this
    }


    override fun onClick(v: View?) {
        mPresenter.addHelpRequest(CommitHelpBuyOrderReq(mAddressEt.text.toString(),
                DateUtils.format( mArriveTimeTv.text.toString()),
                mGoodListEt.text.toString(),
                mPhoneEt.text.toString(),
                mPriceEt.text.toString().toInt(),
                AppPrefsUtils.getInt(BaseConstant.KEY_SP_USERID)))
    }


    override fun onCommitSuccess() {
        toast("提交成功")
        finish()
    }

    override fun onCommitError() {
        toast("提交失败，请稍后再试")
    }
}
