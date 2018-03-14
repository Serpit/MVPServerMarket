package com.itaem.serpit.helpbuy.data.bean

/**
 * Created by Administrator on 2018/3/8 0008.
 */
data class State(val id:Int,
                 val helperTableId:Int,
                 val helperId:Int,
                 val userAcceptState:Int,
                 val arriveState:Int,
                 val createTime:String,
                 val arriveTime:String,
                 val appraise:String)