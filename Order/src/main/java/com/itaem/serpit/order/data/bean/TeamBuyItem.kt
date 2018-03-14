package com.itaem.serpit.order.data.bean

/**
 * Created by Administrator on 2018/3/4 0004.
 */
data class TeamBuyItem(
                        val groupId:Int,
                        val name:String,
                        val shopLogo:String,
                       val endTime:String,
                       val originalPrice:Int,
                       val groupPrice:Int,
                        val surplus:Int,
                        val limitNum:Int )