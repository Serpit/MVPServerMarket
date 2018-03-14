package com.itaem.serpit.order.data.bean

/**
 * {
"id": 8,
"userId": 1,
"groupId": 6,
"isDeliver": "Y",
"num": 6,
"address": "学校",
"phone": "18316866995",
"username": "zlh"
}
 */
data class UserGroupVo(val id:Int,
                       val userId:Int,
                       val groupId:Int,
                       val isDeliver:String,
                       val num:Int,
                       val address:String,
                       val phone:String,
                       val userName:String)