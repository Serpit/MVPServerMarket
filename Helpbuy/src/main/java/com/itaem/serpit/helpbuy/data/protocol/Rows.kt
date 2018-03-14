package com.itaem.serpit.helpbuy.data.protocol

/**
 * {
"id": 5,
"userId": 1,
"listing": "牛肉羊肉鸡肉鸭肉1号",
"address": "潮南区胪岗镇1号",
"arriveTime": "2018-02-27 16:57:06",
"phone": "1356668895",
"price": 150,
"time": "2018-02-09 16:59:38",
"state": 1,
"username": "zlh",
"stateVo": null,
"accepterVoList": null
}
 */


    data class Rows(val id:Int,
                    val userId:Int,
                    val listing:String,
                    val address:String,
                    val arriveTime:String,
                    val phone:String,
                    val price:Int,
                    val time:String,
                    val username:String,
                    val state:Int,
                    val stateVo:String,
                    val accepterVoList:String)

