package com.itaem.serpit.baselibrary.data.protocol

/**
 * Created by Administrator on 2018/2/7 0007.
 */
class BaseResp<out T>(val status:Int,val msg:String ,val data:T)