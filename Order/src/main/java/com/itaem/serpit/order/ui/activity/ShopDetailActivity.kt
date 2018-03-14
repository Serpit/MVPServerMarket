package com.itaem.serpit.order.ui.activity

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.View
import com.example.baselibrary.ui.activity.BaseMvpActivity
import com.itaem.serpit.baselibrary.common.BaseConstant
import com.itaem.serpit.baselibrary.ext.onClick
import com.itaem.serpit.baselibrary.widgets.IncreaseAndReduceView
import com.itaem.serpit.mvpservicemarket.order.R
import com.itaem.serpit.order.data.bean.Good
import com.itaem.serpit.order.data.protocol.ShopDetail
import com.itaem.serpit.order.data.protocol.ShopInfo
import com.itaem.serpit.order.injection.component.DaggerOrderComponent
import com.itaem.serpit.order.injection.module.OrderModule
import com.itaem.serpit.order.presenter.ShopDetailPresenter
import com.itaem.serpit.order.presenter.view.ShopDetailView
import com.itaem.serpit.order.ui.adapter.GoodListAdapter


import com.kotlin.base.utils.AppPrefsUtils
import com.kotlin.base.utils.GlideUtils
import kotlinx.android.synthetic.main.activity_shop_detail.*


/*商店详情(用户看到的)*/
class ShopDetailActivity : BaseMvpActivity<ShopDetailPresenter>(), ShopDetailView, IncreaseAndReduceView.ModifyNumberListener, View.OnClickListener {


    private lateinit var mShopCarList:MutableList<Good>
    private lateinit var mGoodsList:List<ShopDetail.DataBean.GoodListBean>
    private lateinit var goodListAdapter: GoodListAdapter
    private var mCurrentPrice:Float = 0F
    private lateinit var module:ShopInfo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_detail)
        module = intent.getSerializableExtra("ShopInfo") as ShopInfo
        initView()

    }

    private fun initView() {
        mPhoneIv.setOnClickListener(this)
        mExitIv.setOnClickListener(this)
        mConfirmBt.isEnabled = false
        mConfirmBt.setOnClickListener  (this)
        GlideUtils.loadUrlImage(this,module.pic,mShopIv)

        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE)

        collapsingToolbarLayout.title = module.name//设置集市名称
        mTypeTv.text = "类型：${module.type}"

        loadData()
    }


    private fun dialPhone(phone:String){
        val intent = Intent(Intent.ACTION_DIAL)
        val data = Uri.parse("tel:"+phone)
        intent.data = data
        startActivity(intent)

    }
    private fun loadData() {
        goodListAdapter = GoodListAdapter(this,this)
        mPresenter.getShopDetail(module.shopId)

    }
    override fun onGetShopDetailResult(result: ShopDetail) {
        mPhoneIv.onClick { dialPhone(result.data.phone) }
        mNoticeTv.text=  "公告：${result.data.notice}"
        mAddressTv.text = result.data.address
        mGoodsList = result.data.goodList
        mShopCarList = mutableListOf()
        for (good in mGoodsList){
            mShopCarList.add(Good(good.getGoodId(), good.getName(), good.getPrice(), good.getImg(), good.getNumber()))
        }
        goodListAdapter.setData(mGoodsList)
        mGoodListRv.adapter = goodListAdapter
    }

    /*
    * list中添加商品的按钮事件*/
    override fun doAdd(num: Int, position: Int) {
        mShopCarList[position].num = num
        for (good in mShopCarList){
            mCurrentPrice += good.num*good.price.toFloat()
        }
        mCurrentPriceTv.setTextColor(Color.WHITE)
        mCurrentPriceTv.text = "￥${mCurrentPrice}"
        iv_shopCar.setImageResource(R.mipmap.shop_car_full)
        mConfirmBt.setBackgroundColor(resources.getColor(R.color.lightGreen))
        mCurrentPrice = 0F
        mConfirmBt.isEnabled = true
    }

    /*
    * list中移除商品的按钮事件*/
    override fun doSub(num: Int, position: Int) {
        mShopCarList[position].num = num
        for (good in mShopCarList){
            mCurrentPrice += good.num * good.price.toFloat()
        }
        mCurrentPriceTv.setTextColor(Color.WHITE);
        mCurrentPriceTv.text = "￥${mCurrentPrice}"
        if (mCurrentPrice == 0F){
            iv_shopCar.setImageResource(R.mipmap.shop_car_empty)
            mConfirmBt.setBackgroundColor(resources.getColor(R.color.darkGray))
            mConfirmBt.isEnabled =false
        }

        mCurrentPrice = 0F
    }


    override fun onClick(v: View?) {
        when(v?.id){
            R.id.mConfirmBt->{
                val intent = Intent(this,SettlementActivity::class.java)
                intent.putExtra("price",mCurrentPriceTv.text.toString())
                intent.putExtra("goodList", mShopCarList as ArrayList<Good>)
                intent.putExtra("address",AppPrefsUtils.getString(BaseConstant.KEY_SP_ADDRESS))
                intent.putExtra("userName",AppPrefsUtils.getString(BaseConstant.KEY_SP_USERNAME))
                intent.putExtra("shopName",module.name)
                intent.putExtra("shopId",module.shopId)
                intent.putExtra("phone",AppPrefsUtils.getString(BaseConstant.KEY_SP_PHONE))
                startActivity(intent)
            }
            R.id.mExitIv->{
                finish()
            }

        }
    }

    override fun onGetShopDetailFailed() {
        mGoodListRv.visibility = View.GONE
        mHintTv.visibility = View.VISIBLE
    }

    override fun injectComponent() {
        DaggerOrderComponent.builder().activityComponent(activityComponent).orderModule(OrderModule()).build().inject(this)
        mPresenter.mView = this
    }






}
