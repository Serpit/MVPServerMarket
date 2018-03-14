package com.itaem.serpit.order.data.protocol

import com.itaem.serpit.order.data.bean.GroupCart

/**
 *发起团购
"endTime": "2018-03-04T12:39:00.940Z",
"groupCart": [
{
"goodsId": 0,
"name": "string",
"num": 0
}
],
"groupPrice": 0,
"limitNum": 0,
"originalPrice": 0,
"peopleNum": 0,
"shopId": 0,
"startTime": "2018-03-04T12:39:00.940Z"
}
 */
data class GroupReq(val endTime:String,
                    val groupCart: ArrayList<GroupCart>,
                    val groupPrice:Int,
                    val limitNum:Int,
                    val originalPrice:Int,
                    val peopleNum:Int,
                    val shopId:Int,
                    val startTime:String)