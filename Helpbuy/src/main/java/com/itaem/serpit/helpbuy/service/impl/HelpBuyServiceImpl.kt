package com.itaem.serpit.helpbuy.service.impl

import com.itaem.serpit.baselibrary.ext.convert
import com.itaem.serpit.baselibrary.ext.convertBoolean
import com.itaem.serpit.helpbuy.data.protocol.*

import com.itaem.serpit.helpbuy.data.repository.HelpBuyRepository
import com.itaem.serpit.helpbuy.service.HelpBuyService
import rx.Observable
import javax.inject.Inject

/**
 *
 */
class HelpBuyServiceImpl @Inject constructor(): HelpBuyService {
    @Inject
    lateinit var repository :HelpBuyRepository

    override fun getAllHelperTable( page:Int, rows:Int): Observable<HelpBuyRequestInfo> {
        return repository.getAllHelperTable(page,rows)
    }

    override fun acceptRequest(acceptOrderReq: AcceptOrderReq): Observable<Boolean> {
        return repository.acceptRequest(acceptOrderReq).convertBoolean()
    }

    override fun getMyHelperTable(helperId: Int): Observable<AcceptedOrderResp> {
        return repository.getMyAccept(helperId)
    }

    override fun addHelpRequest(commitHelpBuyOrderReq: CommitHelpBuyOrderReq): Observable<Boolean> {
        return repository.addHelpRequest(commitHelpBuyOrderReq).convertBoolean()
    }

    override fun deleteAccept(helperAcceptId: Int): Observable<Boolean> {
        return repository.deleteAccept(helperAcceptId).convertBoolean()
    }

    override fun getMyHelpBuyTable(userId: Int): Observable<List<HelperTable>> {
        return repository.getMyHelperTable(userId).convert()
    }

    override fun agreeHelper(helperTableId: Int, acceptId: Int): Observable<Boolean> {
        return repository.agreeHelper(helperTableId,acceptId).convert()
    }
}