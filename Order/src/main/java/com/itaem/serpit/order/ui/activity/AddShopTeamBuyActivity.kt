package com.itaem.serpit.order.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.baselibrary.ui.activity.BaseMvpActivity
import com.itaem.serpit.baselibrary.common.BaseConstant
import com.itaem.serpit.baselibrary.ext.onClick
import com.itaem.serpit.baselibrary.utils.DateUtils
import com.itaem.serpit.mvpservicemarket.order.R
import com.itaem.serpit.order.data.bean.Good
import com.itaem.serpit.order.data.bean.GroupCart
import com.itaem.serpit.order.data.protocol.GroupReq
import com.itaem.serpit.order.injection.component.DaggerOrderComponent
import com.itaem.serpit.order.injection.module.OrderModule
import com.itaem.serpit.order.presenter.AddShopTeamBuyPresenter
import com.itaem.serpit.order.presenter.view.AddShopTeamBuyView
import com.kotlin.base.utils.AppPrefsUtils
import kotlinx.android.synthetic.main.activity_add_shop_team_buy.*
import org.jetbrains.anko.toast


/*商店添加团购页面*/

class AddShopTeamBuyActivity : BaseMvpActivity<AddShopTeamBuyPresenter>(), AddShopTeamBuyView, View.OnClickListener{
    lateinit var list:ArrayList<GroupCart>
    override fun onClick(v: View?) {
        when(v?.id){

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_shop_team_buy)

        loadData()
        initView()
    }


    private fun initView() {
       val price = intent.getFloatExtra("price",0F)
        mOriginPriceTv.text = "￥${price}"

        mHeaderBar.getRightView().onClick {
            val startTime = DateUtils.format(DateUtils.getCurrentTime())
            Log.d("TIME-NOW",startTime)
            val endTime = DateUtils.format(mEndTimeTv.text.toString())
            mPresenter.group(GroupReq(endTime,list,mGroupPriceEt.text.toString().toInt(),1,price.toInt(),mLimitEt.text.toString().toInt(),AppPrefsUtils.getInt(BaseConstant.KEY_SP_SHOP_ID),startTime)) }
    }

    private fun loadData() {
        list = arrayListOf()
        for (good in intent.extras.getSerializable("goodList") as ArrayList<Good>){
            list.add(GroupCart(good.goodId,good.name,good.num))
        }


    }


    override fun onAddSuccess() {
        toast("提交成功")
        finish()
    }

    override fun onAddFailed() {
        toast("网络错误，提交失败，请稍候重试")
    }



    override fun injectComponent() {
        DaggerOrderComponent.builder().activityComponent(activityComponent).orderModule(OrderModule()).build().inject(this)
        mPresenter.mView = this
    }






}
