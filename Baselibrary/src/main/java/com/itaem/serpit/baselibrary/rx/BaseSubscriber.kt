package com.example.baselibrary.rx


import com.itaem.serpit.baselibrary.presenter.view.BaseView
import com.itaem.serpit.baselibrary.rx.BaseException
import rx.Subscriber

/**
 * Created by Administrator on 2018/1/23 0023.
 */
open class BaseSubscriber<T> (val baseView: BaseView): Subscriber<T>() {
    override fun onNext(t: T) {

    }

    override fun onCompleted() {
        baseView.hideLoading()
    }

    override fun onError(e: Throwable?) {
        baseView.hideLoading()
        if (e is BaseException){
            baseView.onError(e.msg)
        }
    }
}