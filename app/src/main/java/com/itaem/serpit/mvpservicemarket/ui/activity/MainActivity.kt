package com.itaem.serpit.mvpservicemarket.ui.activity

import android.app.AlertDialog
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.baidu.location.Address
import com.baidu.location.BDLocation
import com.baidu.location.BDLocationListener
import com.itaem.serpit.baselibrary.common.BaseConstant
import com.itaem.serpit.helpbuy.ui.fragment.HelpBuyFragment
import com.itaem.serpit.mvpservicemarket.R
import com.itaem.serpit.mvpservicemarket.utils.BDLocationHelper
import com.itaem.serpit.order.ui.fragment.MainFragment
import com.itaem.serpit.order.ui.fragment.TeamBuyFragment
import com.kotlin.base.utils.AppPrefsUtils
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity(),BDLocationListener {


    lateinit var bdLocationHelper: BDLocationHelper
    private val mStack = Stack<Fragment>()
    //主界面Fragment
    private val mHelpBuyFragment by lazy { HelpBuyFragment() }

    //主Fragment
    private val mMainFragment by lazy { MainFragment() }
    private val mTeamBuyFragment by lazy { TeamBuyFragment()  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //初始化位置监听
        bdLocationHelper = BDLocationHelper(this, this)
        initFragment()
        initBottomNav()
        changeFragment(0)
        showAlert()

    }

    override fun onStart() {
        super.onStart()

        bdLocationHelper.startClient()//开启定位
    }

    private fun showAlert() {
        if (!AppPrefsUtils.getBoolean(BaseConstant.KEY_SP_isAlert)){
            val builder = AlertDialog.Builder(this)
            builder.setPositiveButton("了解",object : DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    dialog?.dismiss()
                }
            }).setMessage("数据均为测试使用，如与事实不符，请多多体谅").setTitle("说明")
                    .setNegativeButton("不再提醒",object : DialogInterface.OnClickListener{
                        override fun onClick(dialog: DialogInterface?, which: Int) {
                            AppPrefsUtils.putBoolean(BaseConstant.KEY_SP_isAlert,true)
                            dialog?.dismiss()
                        }
                    })  .show()
        }

    }

    override fun onStop() {
        super.onStop()
        bdLocationHelper.stopClient()//停止定位
    }
    override fun onReceiveLocation(bdLocation: BDLocation?) {
        val address = bdLocation?.address
        if (address!=null){
            if (address.city!=null&&address.district!=null&&address.street!=null)
            AppPrefsUtils.putString(BaseConstant.KEY_SP_LOCATION,address.city + address.district + address.street)
        }
    }

    private fun changeFragment(position: Int) {
        val manager = supportFragmentManager.beginTransaction()
        for (fragment in mStack){
            manager.hide(fragment)
        }

        manager.show(mStack[position])
        manager.commit()
    }

    private fun initBottomNav() {
        mBottomNavBar.setTabSelectedListener(object : BottomNavigationBar.OnTabSelectedListener{
            override fun onTabReselected(position: Int) {
            }

            override fun onTabUnselected(position: Int) {
            }

            override fun onTabSelected(position: Int) {
                changeFragment(position)
            }
        })


    }

    private fun initFragment() {
       val manager = supportFragmentManager.beginTransaction()
        manager.add(R.id.mFragmentContain,mMainFragment)
        manager.add(R.id.mFragmentContain,mTeamBuyFragment)
        manager.add(R.id.mFragmentContain,mHelpBuyFragment)

        manager.commit()
        mStack.add(mMainFragment)
        mStack.add(mTeamBuyFragment)
        mStack.add(mHelpBuyFragment)
    }
}
