package com.itaem.serpit.order.data.repository


import com.itaem.serpit.baselibrary.data.net.RetrofitFactory
import com.itaem.serpit.baselibrary.data.protocol.BaseResp
import com.itaem.serpit.order.data.api.OrderApi
import com.itaem.serpit.order.data.protocol.*

import rx.Observable
import javax.inject.Inject

/**
 * Created by Administrator on 2018/2/15 0015.
 */
class OrderRepository @Inject constructor() {
    fun getShopsList( marketId:Int): Observable<BaseResp<List<ShopInfo>>>{
        return RetrofitFactory.instance.create(OrderApi::class.java).getShopsList(marketId)
    }

    fun getShopDetail(shopId:Int):Observable<ShopDetail>{
        return RetrofitFactory.instance.create(OrderApi::class.java).getShopDetail(shopId)
    }
    fun postOrder(postOrderReq: PostOrderReq):Observable<BaseResp<Boolean>>{
        return RetrofitFactory.instance.create(OrderApi::class.java).postOrder(postOrderReq)
    }

    fun acceptOrder(userId:Int,orderId:Int):Observable<BaseResp<Boolean>>{
        return RetrofitFactory.instance.create(OrderApi::class.java).acceptOrder(userId,orderId)
    }
    fun getMyShopInfo(userId:Int):Observable<BaseResp<GetMyShopInfoResp>>{
        return RetrofitFactory.instance.create(OrderApi::class.java).getMyShopDetail(userId)
    }
    fun insertGood(addGoodReq: AddGoodReq):Observable<BaseResp<Boolean>>{
        return RetrofitFactory.instance.create(OrderApi::class.java).insertGood(addGoodReq)
    }

    fun getMarketGrouping(marketId: Int):Observable<BaseResp<List<TeamBuyInfo>>>{
        return RetrofitFactory.instance.create(OrderApi::class.java).getMarketGrouping(marketId)
    }
    fun updateGood(editGoodReq: EditGoodReq):Observable<BaseResp<Boolean>>{
        return RetrofitFactory.instance.create(OrderApi::class.java).updateGood(editGoodReq)
    }

    fun joinGroups(joinGroupReq: JoinGroupReq):Observable<BaseResp<Boolean>>{
        return RetrofitFactory.instance.create(OrderApi::class.java).joinGroups(joinGroupReq)
    }
    fun getMyGroups(userId: Int):Observable<BaseResp<List<TeamBuyInfo>>>{
        return RetrofitFactory.instance.create(OrderApi::class.java).getMyGroups(userId)
    }

    fun groups(groupReq: GroupReq):Observable<BaseResp<Boolean>>{
        return RetrofitFactory.instance.create(OrderApi::class.java).groups(groupReq)
    }
    fun getGroupBishopId(shopId: Int):Observable<BaseResp<List<TeamBuyInfo>>>{
        return RetrofitFactory.instance.create(OrderApi::class.java).getGroupsByshopId(shopId)
    }
}