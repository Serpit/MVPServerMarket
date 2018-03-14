package com.example.baselibrary.ui.activity

import android.os.Bundle
import com.example.baselibrary.presenter.view.BasePresenter
import com.itaem.serpit.baselibrary.common.BaseApplication
import com.itaem.serpit.baselibrary.injection.component.ActivityComponent
import com.itaem.serpit.baselibrary.injection.component.DaggerActivityComponent
import com.itaem.serpit.baselibrary.injection.module.ActivityModule
import com.itaem.serpit.baselibrary.injection.module.LifeCycleProviderModule
import com.itaem.serpit.baselibrary.presenter.view.BaseView
import com.itaem.serpit.baselibrary.widgets.ProgressLoading

import org.jetbrains.anko.toast
import javax.inject.Inject


/**
 * Created by Administrator on 2018/1/23 0023.
 */
open abstract class BaseMvpActivity<T: BasePresenter<*>> : BaseActivity(), BaseView {

    @Inject
    lateinit var mPresenter:T

    private lateinit var mLoadingDialog:ProgressLoading
    lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        initActivityInjection()
        injectComponent()

        mLoadingDialog = ProgressLoading.create(this)
    }
    override fun showLoading() {
        mLoadingDialog.showLoading()
    }

    override fun hideLoading() {
        mLoadingDialog.hideLoading()
    }

    override fun onError(text:String) {
        toast(text)
    }



    abstract fun  injectComponent()

    private fun initActivityInjection() {
        activityComponent = DaggerActivityComponent.builder()
                .appComponent((application as BaseApplication).appComponent)
                .activityModule(ActivityModule(this))
                .lifeCycleProviderModule(LifeCycleProviderModule(this)).build()
    }
}