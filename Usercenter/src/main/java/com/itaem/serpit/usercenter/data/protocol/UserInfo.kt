package com.itaem.serpit.usercenter.data.protocol

/*{
    "userId": 3,
    "realName": "",
    "phone": "string",
    "age": 0,
    "qq": "",
    "email": "",
    "wechat": "",
    "address": "string",
    "other_link": "",
    "picture": "",
    "token": "22177124-b1c8-44b1-a6ca-0a2aba9d9b02",
    "shopper": false,
    "helper": false
  }*/
data  class UserInfo(val userId:Int,
                     val realName:String,
                     val phone:String,
                     val age:Int,
                     val qq:String,
                     val email:String,
                     val wechat:String,
                     val address:String,
                     val other_link:String,
                     val picture:String,
                     val token:String,
                     val shopper:Boolean,
                     val helper:Boolean)