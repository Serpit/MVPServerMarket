package com.itaem.serpit.baselibrary.widgets

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import com.itaem.serpit.baselibrary.R
import com.itaem.serpit.baselibrary.ext.onClick


import kotlinx.android.synthetic.main.layout_header_bar.view.*

/**
 * Created by Administrator on 2018/1/31 0031.
 */
class HeaderBar @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var isShowBack = true
    private var backgroundColor:Int ? = null
    private var titleColor:Int? = null
    private var titleText:String? = null
    private var rightText:String? = null
    init {
        val  typedArray = context.obtainStyledAttributes(attrs, R.styleable.HeaderBar)
        titleColor = typedArray.getColor(R.styleable.HeaderBar_titleColor,context.resources.getColor(R.color.common_black))
        backgroundColor = typedArray.getColor(R.styleable.HeaderBar_backgroundColor,context.resources.getColor(R.color.common_white))
        isShowBack = typedArray.getBoolean(R.styleable.HeaderBar_isShowBack,true)
        titleText = typedArray.getString(R.styleable.HeaderBar_titleText)
        rightText = typedArray.getString(R.styleable.HeaderBar_rightText)
        initView()
        typedArray.recycle()
    }

    private fun initView() {
        View.inflate(context,R.layout.layout_header_bar,this)
        mBackground.setBackgroundColor(backgroundColor!!)
        mTitleTv.setTextColor(titleColor!!)
        mLeftIv.visibility = if(isShowBack) View.VISIBLE else View.GONE
        titleText?.let {
           mTitleTv.text = it
        }
        rightText?.let {
            mRightTv.text = it
            mRightTv.visibility = View.VISIBLE
        }

        mLeftIv.onClick {
            if (context is Activity){
                (context as Activity).finish()
            }
        }
    }

    fun getRightView():TextView{
        return mRightTv
    }
}