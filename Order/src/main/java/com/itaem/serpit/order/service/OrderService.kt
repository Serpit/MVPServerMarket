package com.itaem.serpit.order.service

import com.itaem.serpit.order.data.protocol.*
import rx.Observable


/**
 * Created by Administrator on 2018/2/24 0024.
 */
interface OrderService {
    fun getShops(marketId:Int): Observable<List<ShopInfo>>
    fun getShopDetail(shopId:Int):Observable<ShopDetail>
    fun postOrder(postOrderReq: PostOrderReq):Observable<Boolean>
    fun acceptOrder(userId:Int,orderId:Int):Observable<Boolean>
    fun getMyShopDetail(userId: Int):Observable<GetMyShopInfoResp>
    fun insertGood(addGoodReq: AddGoodReq):Observable<Boolean>
    fun updateGood(editGoodReq: EditGoodReq):Observable<Boolean>
    fun getMarketGrouping(marketId: Int):Observable<List<TeamBuyInfo>>
    fun joinGroups(joinGroupReq: JoinGroupReq):Observable<Boolean>
    fun getMyGrouping(userId: Int):Observable<List<TeamBuyInfo>>
    fun groups(groupReq: GroupReq):Observable<Boolean>
    fun getGroupsByshopId(shopId: Int):Observable<List<TeamBuyInfo>>
}