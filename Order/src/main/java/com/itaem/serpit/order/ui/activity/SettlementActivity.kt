package com.itaem.serpit.order.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.baselibrary.ui.activity.BaseMvpActivity
import com.itaem.serpit.baselibrary.common.AppManager
import com.itaem.serpit.baselibrary.common.BaseConstant

import com.itaem.serpit.mvpservicemarket.order.R
import com.itaem.serpit.order.common.Constant
import com.itaem.serpit.order.data.bean.Good
import com.itaem.serpit.order.data.protocol.PostOrderReq
import com.itaem.serpit.order.data.protocol.ShopCart
import com.itaem.serpit.order.injection.component.DaggerOrderComponent
import com.itaem.serpit.order.injection.module.OrderModule
import com.itaem.serpit.order.presenter.SettlementPresenter
import com.itaem.serpit.order.presenter.view.SettlementView
import com.itaem.serpit.order.widgets.ShopListItemView


import com.kotlin.base.utils.AppPrefsUtils

import kotlinx.android.synthetic.main.activity_settlement.*
import org.jetbrains.anko.toast


/*结算页面*/
class SettlementActivity : BaseMvpActivity<SettlementPresenter>(), SettlementView, View.OnClickListener {
    private val shopCartList = arrayListOf<ShopCart>()
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.mConfirmBt->{
                var deliver = "否"
                if (!mBookRBt.isChecked){
                    deliver = "是"
                }
                intent.extras.getString("shopId")
                mPresenter.postOrder(PostOrderReq(mAddressTv.text.toString(),deliver,mPhoneTv.text.toString()
                ,mRemarkTv.text.toString(),shopCartList,intent.extras.getInt("shopId"),AppPrefsUtils.getInt(BaseConstant.KEY_SP_USERID)))
            }
            R.id.mSetMsgLL ->{
                val intent = Intent(this,SetMsgActivity::class.java)
                startActivityForResult(intent,0)
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settlement)

        initView()

    }

    private fun initView() {

        mShopNameTv.text = intent.extras.getString("shopName")
        mUserNameTv.text = intent.extras.getString("userName")
        mPhoneTv.text = intent.extras.getString("phone")
        mCurrentPriceTv.text = "待支付${intent.extras.getString("price")}"
        mPriceTv.text = intent.extras.getString("price")
        mConfirmBt.setOnClickListener(this)
        mSetMsgLL.setOnClickListener(this)
        for (good in intent.extras.getSerializable("goodList") as ArrayList<Good>){
            if (good.num!=0){
                shopCartList.add(ShopCart(good.goodId,good.num))
                mGoodListLL.addView(ShopListItemView(good.name,
                        good.num,(good.price*good.num).toFloat(),this,null,0))
            }

        }
    }


    override fun onPostOrderSuccess() {
        toast("提交成功")
        AppManager.instance.finishActivity(this)
    }

    override fun onPostOrderFail() {
        toast("提交失败")
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode==Constant.RESULT_FROM_SET_MSG){
            mUserNameTv.text = data!!.extras.getString("name")
            mPhoneTv.text = data!!.extras.getString("phone")
            mAddressTv.text = data!!.extras.getString("address")
        }
    }
    override fun injectComponent() {
        DaggerOrderComponent.builder().activityComponent(activityComponent).orderModule(OrderModule()).build().inject(this)
        mPresenter.mView = this
    }






}
