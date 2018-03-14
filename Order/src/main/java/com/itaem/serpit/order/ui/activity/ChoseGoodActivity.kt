package com.itaem.serpit.order.ui.activity


import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import com.example.baselibrary.ui.activity.BaseMvpActivity
import com.itaem.serpit.baselibrary.widgets.IncreaseAndReduceView
import com.itaem.serpit.mvpservicemarket.order.R
import com.itaem.serpit.order.data.bean.Good
import com.itaem.serpit.order.data.protocol.ShopDetail
import com.itaem.serpit.order.injection.component.DaggerOrderComponent
import com.itaem.serpit.order.injection.module.OrderModule
import com.itaem.serpit.order.presenter.ChoseGoodTeamBuyPresenter
import com.itaem.serpit.order.presenter.view.ChoseGoodTeamBuyView
import com.itaem.serpit.order.ui.adapter.GoodListAdapter
import kotlinx.android.synthetic.main.activity_chose_good_group.*
import org.jetbrains.anko.toast


/*添加团购页面-选择商品*/

class ChoseGoodActivity : BaseMvpActivity<ChoseGoodTeamBuyPresenter>(), ChoseGoodTeamBuyView, View.OnClickListener, IncreaseAndReduceView.ModifyNumberListener {

    private lateinit var mShopCarList:MutableList<Good>
    //private lateinit var mGoodsList:List<ShopDetail.DataBean.GoodListBean>
    private lateinit var goodListAdapter: GoodListAdapter
    private var mCurrentPrice:Float = 0F
    private var mPrice= 0F
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chose_good_group)
        initView()

    }

    override fun onResume() {
        super.onResume()
        loadData()
    }
    private fun initView() {
        mConfirmBt.isEnabled = false
        mConfirmBt.setOnClickListener(this)
        goodListAdapter = GoodListAdapter(this,this)
        mListRv.adapter = goodListAdapter

    }

    private fun loadData() {
        mPresenter.getMyShopGoodList()
    }


    override fun onGetListSuccess(list: List<ShopDetail.DataBean.GoodListBean>) {
        mShopCarList = mutableListOf()
        for (good in list){
            mShopCarList.add(Good(good.getGoodId(), good.getName(), good.getPrice(), good.getImg(), good.getNumber()))
        }

        goodListAdapter.setData(list)
    }

    override fun onGetListFailed() {
       toast("获取商品列表失败")
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.mConfirmBt ->{
                val intent = Intent(this,AddShopTeamBuyActivity::class.java)
                intent.putExtra("goodList",mShopCarList as ArrayList<Good>)
                intent.putExtra("price",mPrice)
                startActivity(intent)
                finish()
            }
        }
    }

    override fun doAdd(num: Int, position: Int) {
        mShopCarList[position].num = num
        for (good in mShopCarList){
            mCurrentPrice += good.num*good.price.toFloat()
        }
        mCurrentPriceTv.setTextColor(Color.WHITE)
        mPrice = mCurrentPrice
        mCurrentPriceTv.text = "￥${mCurrentPrice}"

        mConfirmBt.setBackgroundColor(resources.getColor(R.color.lightGreen))
        mCurrentPrice = 0F
        mConfirmBt.isEnabled = true
    }

    override fun doSub(num: Int, position: Int) {
        mShopCarList[position].num = num
        for (good in mShopCarList){
            mCurrentPrice += good.num * good.price.toFloat()
        }
        mCurrentPriceTv.setTextColor(Color.WHITE)
        mPrice = mCurrentPrice
        mCurrentPriceTv.text = "￥${mCurrentPrice}"
        if (mCurrentPrice == 0F){

            mConfirmBt.setBackgroundColor(resources.getColor(R.color.darkGray))
            mConfirmBt.isEnabled =false
        }

        mCurrentPrice = 0F
    }

    override fun injectComponent() {
        DaggerOrderComponent.builder().activityComponent(activityComponent).orderModule(OrderModule()).build().inject(this)
        mPresenter.mView = this
    }






}
