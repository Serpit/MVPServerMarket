package com.itaem.serpit.helpbuy.data.protocol

/**
 * {
"address": "string",
"arriveTime": "2018-02-22T10:46:42.464Z",
"listing": "string",
"phone": "string",
"price": 0,
"userId": 1
}
 */
data class CommitHelpBuyOrderReq (val address:String,
                                  val arriveTime:String,
                                  val listing:String,
                                  val phone:String,
                                  val price:Int,
                                  val userId:Int)