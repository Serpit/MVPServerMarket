package com.example.baselibrary.presenter.view

import android.content.Context
import com.itaem.serpit.baselibrary.presenter.view.BaseView
import com.kotlin.base.utils.NetWorkUtils

import com.trello.rxlifecycle.LifecycleProvider
import javax.inject.Inject

/**
 * Created by Administrator on 2018/1/23 0023.
 * 接收一个继承BaseView的泛型，在里面持有一个View层的引用
 */
open class BasePresenter<T: BaseView> {
    lateinit var mView:T

    @Inject
    lateinit var lifeCycleProvider: LifecycleProvider<*>

    @Inject
    lateinit var context:Context

    fun checkNetWork():Boolean{
        if(NetWorkUtils.isNetWorkAvailable(context)){
            return true
        }
        mView.onError("网络不可用")
        return false
    }
}