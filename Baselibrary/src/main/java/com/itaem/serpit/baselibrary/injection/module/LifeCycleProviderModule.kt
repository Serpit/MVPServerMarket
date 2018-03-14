package com.itaem.serpit.baselibrary.injection.module

import com.trello.rxlifecycle.LifecycleProvider
import dagger.Module
import dagger.Provides

/**
 * Created by Administrator on 2018/1/31 0031.
 */
@Module
class LifeCycleProviderModule(private val lifeCycleProvider: LifecycleProvider<*>) {
    @Provides
    fun providesLifeCycleProviderModule():LifecycleProvider<*>{
        return lifeCycleProvider
    }
}