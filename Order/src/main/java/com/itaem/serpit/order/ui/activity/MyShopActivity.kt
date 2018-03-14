package com.itaem.serpit.order.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.baselibrary.ui.activity.BaseMvpActivity
import com.itaem.serpit.baselibrary.ext.onClick
import com.itaem.serpit.mvpservicemarket.order.R
import com.itaem.serpit.order.data.protocol.GetMyShopInfoResp
import com.itaem.serpit.order.data.protocol.ShopDetail
import com.itaem.serpit.order.injection.component.DaggerOrderComponent
import com.itaem.serpit.order.injection.module.OrderModule
import com.itaem.serpit.order.presenter.MyShopPresenter
import com.itaem.serpit.order.presenter.view.MyShopView
import kotlinx.android.synthetic.main.activity_shoper_info.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast


/*我的商店页面*/
@Route(path = "/Order/MyShopActivity")
class MyShopActivity : BaseMvpActivity<MyShopPresenter>(), MyShopView, View.OnClickListener {
    private lateinit var goodList:ArrayList<ShopDetail.DataBean.GoodListBean>

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.mHelpBuyMsgLL->{
                startActivity<ShopTeamBuyInfoActivity>()
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shoper_info)
        loadData()
        initView()

    }

    private fun loadData() {
        mPresenter.loadShopInfo()
    }

    private fun initView() {
        mHelpBuyMsgLL.setOnClickListener(this)
        iv_exit.onClick { finish() }
        mGoodLL.onClick {
            val intent = Intent(this,ShopGoodManageActivity::class.java)
            intent.putExtra("goodList",goodList)
            startActivity(intent)
        }

    }


    override fun onGetMyShopInfoSuccess(result: GetMyShopInfoResp) {
        mShopNameTv.text =  result.name
        goodList =  result.goodList as ArrayList<ShopDetail.DataBean.GoodListBean>
    }

    override fun onGetMyShopInfoFailed() {
        toast("加载数据失败")
    }

    override fun injectComponent() {
        DaggerOrderComponent.builder().activityComponent(activityComponent).orderModule(OrderModule()).build().inject(this)
        mPresenter.mView = this
    }






}
