package com.itaem.serpit.order.service.impl

import com.itaem.serpit.baselibrary.ext.convert
import com.itaem.serpit.baselibrary.ext.convertBoolean
import com.itaem.serpit.order.data.protocol.*
import com.itaem.serpit.order.data.repository.OrderRepository
import com.itaem.serpit.order.service.OrderService
import rx.Observable
import javax.inject.Inject

/**
 *
 */
class OrderServiceImpl @Inject constructor(): OrderService {
    @Inject
    lateinit var repository :OrderRepository

    override fun getShops(marketId:Int): Observable<List<ShopInfo>> {
        return repository.getShopsList(marketId).convert()
    }

    override fun getShopDetail(shopId: Int): Observable<ShopDetail> {
        return repository.getShopDetail(shopId)
    }

    override fun postOrder(postOrderReq: PostOrderReq): Observable<Boolean> {
        return repository.postOrder(postOrderReq).convertBoolean()
    }

    override fun acceptOrder(userId: Int, orderId: Int): Observable<Boolean> {
        return repository.acceptOrder(userId,orderId).convertBoolean()
    }

    override fun getMyShopDetail(userId: Int): Observable<GetMyShopInfoResp> {
        return repository.getMyShopInfo(userId).convert()
    }

    override fun insertGood(addGoodReq: AddGoodReq): Observable<Boolean> {
        return  repository.insertGood(addGoodReq).convert()
    }
    override fun updateGood(editGoodReq: EditGoodReq): Observable<Boolean> {
        return  repository.updateGood(editGoodReq).convert()
    }

    override fun getMarketGrouping(marketId: Int): Observable<List<TeamBuyInfo>> {
        return  repository.getMarketGrouping(marketId).convert()
    }

    override fun joinGroups(joinGroupReq: JoinGroupReq): Observable<Boolean> {
        return  repository.joinGroups(joinGroupReq).convertBoolean()
    }

    override fun getMyGrouping(userId: Int): Observable<List<TeamBuyInfo>> {
        return repository.getMyGroups(userId).convert()
    }
    override fun groups(groupReq: GroupReq): Observable<Boolean> {
        return repository.groups(groupReq).convertBoolean()
    }
    override fun getGroupsByshopId(shopId: Int): Observable<List<TeamBuyInfo>> {
        return repository.getGroupBishopId(shopId).convert()
    }
}