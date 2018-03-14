package com.itaem.serpit.baselibrary.presenter.view

/**
 * Created by Administrator on 2018/1/23 0023.
 * 通常View层定义的View层方法
 */
interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun onError(text:String)
}