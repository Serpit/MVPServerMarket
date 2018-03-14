package com.itaem.serpit.helpbuy.data.bean

/**
 * {
id: 15,
helperId: 9,
helperTableId: 19,
deadTime: "2018-03-08 18:41:31",
acceptTime: "2018-03-08 10:42:04",
phone: "123456",
state: 1,
helperName: "serpit1"
}
 */
data class Accepter(val id:Int,
                    val helperId:Int,
                    val helperTableId:Int,
                    val deadTime:String,
                    val acceptTime:String,
                    val phone:String,
                    val state:Int,
                    val helperName:String)