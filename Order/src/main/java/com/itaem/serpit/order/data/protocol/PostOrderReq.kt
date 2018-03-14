package com.itaem.serpit.order.data.protocol

/**
 * {
"address": "string",
"deliver": "string",
"phone": "string",
"remark": "string",
"shopCart": [
{
"id": 1,
"num": 1
}
],
"shopId": 1,
"userId": 1
}
 */
data class PostOrderReq (val address:String,
                         val deliver:String,
                         val phone:String,
                         val remark:String,
                         val shopCart:List<ShopCart>,
                         val shopId:Int,
                         val userId:Int)