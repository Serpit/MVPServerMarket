package com.kotlin.base.widgets

import android.content.Context
import android.util.AttributeSet
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.itaem.serpit.baselibrary.R


/*
    底部导航
 */
class BottomNavBar @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BottomNavigationBar(context, attrs, defStyleAttr) {


    init {
        //首页
        val homeItem = BottomNavigationItem(R.drawable.shop_tab_light,resources.getString(R.string.nav_bar_home))
                .setInactiveIconResource(R.drawable.shop_tab_dark)
                .setActiveColorResource(R.color.lightGreen)
                .setInActiveColorResource(R.color.text_normal)





        //团购
        val teamBuyItem = BottomNavigationItem(R.drawable.teambuy_tab_light,resources.getString(R.string.nav_bar_team_buy))
                .setInactiveIconResource(R.drawable.teambuy_tab_dark)
                .setActiveColorResource(R.color.lightGreen)
                .setInActiveColorResource(R.color.text_normal)



        //代购
        val helpBuyItem = BottomNavigationItem(R.drawable.helpbuy_tab_light,resources.getString(R.string.nav_bar_help_buy))
                .setInactiveIconResource(R.drawable.helpbuy_tab_dark)
                .setActiveColorResource(R.color.lightGreen)
                .setInActiveColorResource(R.color.text_normal)

        //设置底部导航模式及样式
        setMode(BottomNavigationBar.MODE_FIXED)
        setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
        setBarBackgroundColor(R.color.common_white)
        //添加Tab
        addItem(homeItem)
                .addItem(teamBuyItem)
                .addItem(helpBuyItem)
                .setFirstSelectedPosition(0)
                .initialise()
    }



}
