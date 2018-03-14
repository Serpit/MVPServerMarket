package com.itaem.serpit.order.data.protocol

/**
 * {

"markId": 1,
"name": "鸡蛋",
"number": 1,
"picture": "string",
"price": 0,
"shopId":17
}
 */
data class AddGoodReq(val markId:Int,
                      val name:String,
                      val number:Int,
                      val picture:String,
                      val price:Int,
                      val shopId:Int)