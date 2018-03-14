package com.itaem.serpit.order.data.protocol

import com.itaem.serpit.order.data.bean.GoodVo
import com.itaem.serpit.order.data.bean.ShopVo
import com.itaem.serpit.order.data.bean.UserGroupVo

/**团购json
 *  {
"id": 6,
"peopleNum": 85,
"startTime": "2017-12-31 00:00:00",
"endTime": "2018-03-15 10:00:00",
"originalPrice": 150,
"groupPrice": 110,
"limitNum": 2,
"surplus": 79,
"shopVo": {
"name": "大腕饭",
"pic": "loki",
"type": "饭",
"descripe": "kdjife",
"satisfaction": "5",
"shopId": 1
},
"userGroupVo": [
{
"id": 8,
"userId": 1,
"groupId": 6,
"isDeliver": "Y",
"num": 6,
"address": "学校",
"phone": "18316866995",
"username": "zlh"
}
],
"goodVo": [
{
"id": 8,
"name": "牛肉",
"num": 10
},
{
"id": 9,
"name": "牛肉丸",
"num": 20
}
]
}
 */
class TeamBuyInfo(val id:Int,
                  val peopleNum:Int,
                  val startTime:String,
                  val endTime:String,
                  val originalPrice:Int,
                  val groupPrice:Int,
                  val limitNum:Int,
                  val surplus:Int,
                  val shopVo:ShopVo,
                  val userGroupVo:List<UserGroupVo>,
                  val goodVo:List<GoodVo>)