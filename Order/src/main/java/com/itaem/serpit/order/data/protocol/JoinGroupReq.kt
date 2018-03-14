package com.itaem.serpit.order.data.protocol

/**
 * 参团请求
 */
data class JoinGroupReq(val address:String,
                        val groupId:Int,
                        val isDeliver:String,
                        val num:Int,
                        val phone:String,
                        val userId:Int)