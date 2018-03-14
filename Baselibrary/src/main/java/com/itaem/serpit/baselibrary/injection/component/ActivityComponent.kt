package com.itaem.serpit.baselibrary.injection.component

import android.app.Activity
import android.content.Context
import com.itaem.serpit.baselibrary.injection.ActivityScope
import com.itaem.serpit.baselibrary.injection.module.ActivityModule
import com.itaem.serpit.baselibrary.injection.module.LifeCycleProviderModule
import com.trello.rxlifecycle.LifecycleProvider
import dagger.Component

/**
 * Created by Administrator on 2018/2/8 0008.
 */
@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class),modules = arrayOf(ActivityModule::class,LifeCycleProviderModule::class))
interface ActivityComponent {
    fun activity(): Activity
    fun context(): Context
    fun lifeCycleProvider(): LifecycleProvider<*>
}