package com.itaem.serpit.helpbuy.ui.activity

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.util.Log
import android.view.View
import com.example.baselibrary.ui.activity.BaseMvpActivity
import com.itaem.serpit.baselibrary.common.BaseConstant
import com.itaem.serpit.baselibrary.ext.onClick
import com.itaem.serpit.helpbuy.injection.component.DaggerHelpBuyComponent
import com.itaem.serpit.helpbuy.injection.module.HelpBuyModule
import com.itaem.serpit.helpbuy.presenter.RequestDetailPresenter
import com.itaem.serpit.helpbuy.presenter.view.RequestDetailView
import com.itaem.serpit.helpbuy.ui.fragment.AcceptedFragment
import com.itaem.serpit.helpbuy.ui.fragment.NewReqFragment
import com.itaem.serpit.mvpservicemarket.helpbuy.R

import kotlinx.android.synthetic.main.activity_request_detail.*
import java.util.*

class RequestDetailActivity : BaseMvpActivity<RequestDetailPresenter>(), RequestDetailView, View.OnClickListener {

    //Fragment栈管理
    private val mStack = Stack<Fragment>()
    //新请求Fragment
    private val mNewReqFragment:NewReqFragment by lazy { NewReqFragment() }
    private val mAcceptedFragment:AcceptedFragment by lazy { AcceptedFragment() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request_detail)


        initFragment()

        changeFragment(0)

        initView()
    }



    private fun initFragment() {
        val manager = supportFragmentManager.beginTransaction()
        manager.add(R.id.mContainer,mNewReqFragment)
        manager.add(R.id.mContainer,mAcceptedFragment)
        manager.commit()
        mStack.add(mNewReqFragment)
        mStack.add(mAcceptedFragment)

    }

    private fun changeFragment(position: Int) {
        val manager = supportFragmentManager.beginTransaction()
        for (fragment in mStack){
            manager.hide(fragment)
        }

        manager.show(mStack[position])
        manager.commit()
    }
    private fun initView() {

        mTabLayout.addTab(mTabLayout.newTab().setText("新请求"))
        mTabLayout.addTab(mTabLayout.newTab().setText("已接受"))

        mTabLayout.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {


            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                changeFragment(tab?.position!!)
            }
        })




    }



    override fun injectComponent() {
        DaggerHelpBuyComponent.builder().activityComponent(activityComponent).helpBuyModule(HelpBuyModule()).build().inject(this)
        mPresenter.mView = this
    }


    override fun onClick(v: View?) {
        when(v?.id){

        }
    }



}
