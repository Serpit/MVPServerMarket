package com.itaem.serpit.helpbuy.data.protocol


/*
{
    "deadTime": "2018-02-21T14:49:19.534Z",
    "helperId": 0,
    "helperTableId": 0,
    "phone": "string"
}*/
data class AcceptOrderReq(val deadTime:String,
                          val helperId:Int,
                          val helperTableId:Int,
                          val phone:String)