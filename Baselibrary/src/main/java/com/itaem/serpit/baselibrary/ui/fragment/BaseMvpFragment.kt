package com.example.baselibrary.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.baselibrary.presenter.view.BasePresenter
import com.itaem.serpit.baselibrary.common.BaseApplication
import com.itaem.serpit.baselibrary.injection.component.DaggerFragmentComponent
import com.itaem.serpit.baselibrary.injection.component.FragmentComponent
import com.itaem.serpit.baselibrary.injection.module.FragmentModule
import com.itaem.serpit.baselibrary.injection.module.LifeCycleProviderModule
import com.itaem.serpit.baselibrary.presenter.view.BaseView
import com.itaem.serpit.baselibrary.widgets.ProgressLoading
import org.jetbrains.anko.support.v4.toast
import javax.inject.Inject


/**
 * Created by Administrator on 2018/1/23 0023.
 */
open abstract class BaseMvpFragment<T:BasePresenter<*>> : BaseFragment(), BaseView {





    override fun showLoading() {
        mLoadingDialog.showLoading()
    }

    override fun hideLoading() {
        mLoadingDialog.hideLoading()
    }

    override fun onError(text:String) {
        toast(text)
    }
    @Inject
    lateinit var mPresenter:T

    private lateinit var mLoadingDialog:ProgressLoading
    lateinit var fragmentComponent: FragmentComponent
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        initFragmentInjection()
        injectComponent()
        mLoadingDialog = ProgressLoading.create(context)
        return super.onCreateView(inflater, container, savedInstanceState)
    }


    abstract fun  injectComponent()

    private fun initFragmentInjection() {
        fragmentComponent = DaggerFragmentComponent.builder()
                .appComponent((activity.application as BaseApplication).appComponent)
                .fragmentModule(FragmentModule(this))
                .lifeCycleProviderModule(LifeCycleProviderModule(this)).build()
    }
}