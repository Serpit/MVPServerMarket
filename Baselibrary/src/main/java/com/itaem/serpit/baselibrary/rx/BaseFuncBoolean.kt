package com.example.baselibrary.rx


import com.itaem.serpit.baselibrary.common.ResultCode
import com.itaem.serpit.baselibrary.data.protocol.BaseResp
import com.itaem.serpit.baselibrary.rx.BaseException
import rx.Observable
import rx.functions.Func1

/**
 * Created by Administrator on 2018/1/31 0031.
 */
class BaseFuncBoolean<T>:Func1<BaseResp<T>,Observable<Boolean>> {
    override fun call(t: BaseResp<T>): Observable<Boolean> {
        if (t.status != ResultCode.SUCCESS ) {
            return Observable.error(BaseException(t.status, t.msg))
        }
        return Observable.just(true)
    }

}