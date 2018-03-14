package com.itaem.serpit.usercenter.data.protocol

/**
 * {
"address": "string",
"des": "string",
"marketId":5,
"name": "string",
"notice": "string",
"phone": "string",
"type": "string",
"userId":1
}
 */
data class RegisterShoperReq (val address:String,
                              val des:String,
                              val marketId:Int,
                              val name:String,
                              val notice:String,
                              val phone:String,
                              val type:String,
                              val userId:Int)