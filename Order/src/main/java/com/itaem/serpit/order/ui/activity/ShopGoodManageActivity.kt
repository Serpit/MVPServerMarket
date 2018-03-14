package com.itaem.serpit.order.ui.activity

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import com.example.baselibrary.ui.activity.BaseActivity
import com.itaem.serpit.mvpservicemarket.order.R
import com.itaem.serpit.order.data.protocol.ShopDetail
import com.itaem.serpit.order.ui.fragment.HaveBeenOnFragment
import com.itaem.serpit.order.ui.fragment.HaveOutOfStockFragment
import kotlinx.android.synthetic.main.activity_good_manage.*
import java.util.*


/*商店商品管理*/
class ShopGoodManageActivity : BaseActivity() {
    //Fragment栈管理
    private val mStack = Stack<Fragment>()
    //已上架Fragment
    private lateinit var mHaveBeenOnFragment:HaveBeenOnFragment
    //已下架Fragment
    private val mHaveOutStock:HaveOutOfStockFragment by lazy { HaveOutOfStockFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_good_manage)



        initFragment()
        changeFragment(0)
        initView()
        mHaveBeenOnFragment.setData(intent.extras.getSerializable("goodList") as ArrayList<ShopDetail.DataBean.GoodListBean>)
    }


    private fun changeFragment(position: Int) {
        val manager = supportFragmentManager.beginTransaction()
        for (fragment in mStack){
            manager.hide(fragment)
        }

        manager.show(mStack[position])
        manager.commit()
    }

    private fun initFragment() {
        mHaveBeenOnFragment = HaveBeenOnFragment()
        val manager = supportFragmentManager.beginTransaction()
        manager.add(R.id.mContainer,mHaveBeenOnFragment)

        manager.add(R.id.mContainer, mHaveOutStock)
        manager.commit()
        mStack.add(mHaveBeenOnFragment)
        mStack.add(mHaveOutStock)
    }

    private fun initView() {
        mTabLayout.addTab(mTabLayout.newTab().setText("已上架"))
        mTabLayout.addTab(mTabLayout.newTab().setText("已下架"))

        mTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {


            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                changeFragment(tab?.position!!)
            }
        })
    }


}














