package com.itaem.serpit.baselibrary.injection.component

import android.content.Context
import android.support.v4.app.Fragment
import com.itaem.serpit.baselibrary.injection.FragmentScope
import com.itaem.serpit.baselibrary.injection.module.FragmentModule
import com.itaem.serpit.baselibrary.injection.module.LifeCycleProviderModule
import com.trello.rxlifecycle.LifecycleProvider
import dagger.Component

/**
 * Created by Administrator on 2018/2/19 0019.
 */
@FragmentScope
@Component(dependencies = arrayOf(AppComponent::class),modules = arrayOf(FragmentModule::class, LifeCycleProviderModule::class))
interface FragmentComponent {
    fun fragment(): Fragment
    fun context(): Context
    fun lifeCycleProvider(): LifecycleProvider<*>
}