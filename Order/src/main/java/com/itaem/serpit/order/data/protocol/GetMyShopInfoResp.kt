package com.itaem.serpit.order.data.protocol

/**
 *{
"id": 17,
"name": "叉烧店",
"logo": "",
"phone": "123456",
"type": "string",
"address": "string",
"notice": "string",
"marketId": 1,
"userId": 7,
"des": "string",
"satisfaction": "5",
"goodList": [
{
"goodId": 20,
"name": "叉烧",
"price": 0,
"img": "string",
"number": 2
}
]
}
 */
data class GetMyShopInfoResp (val id:Int,
                              val name:String,
                              val phone:String,
                              val logo:String,
                              val type:String,
                              val address:String,
                              val notice:String,
                              val marketId:Int,
                              val userId:Int,
                              val des:String,
                              val satisfaction:String,
                              val goodList:List<ShopDetail.DataBean.GoodListBean>)