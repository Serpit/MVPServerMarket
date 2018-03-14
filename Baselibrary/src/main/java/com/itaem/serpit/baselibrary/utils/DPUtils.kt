package com.itaem.serpit.baselibrary.utils

import android.content.Context
import android.util.TypedValue

/**
 * Created by Administrator on 2018/2/22 0022.
 */
class DPUtils {


    companion object {
        fun px2dp(context: Context,pxVal:Float):Float{
            val scale = context.resources.displayMetrics.density
            return (pxVal/scale)
        }


        fun  dp2px(context: Context,dpVal:Float):Int{
            return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dpVal,context.resources.displayMetrics).toInt()
        }

    }

}