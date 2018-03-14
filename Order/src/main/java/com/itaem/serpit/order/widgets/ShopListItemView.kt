package com.itaem.serpit.order.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.itaem.serpit.mvpservicemarket.order.R

import kotlinx.android.synthetic.main.item_good_list_settlement.view.*


/**
 * Created by Administrator on 2018/2/25 0025.
 */
class ShopListItemView @JvmOverloads constructor(name:String,number:Int,
        price:Float,context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    //private lateinit var view : View
    init {
        View.inflate(context, R.layout.item_good_list_settlement,this)
        mGoodName.text = name
        mGoodPrice.text = "￥${price}"
        mGoodNum.text = "X${number}"
    }



}