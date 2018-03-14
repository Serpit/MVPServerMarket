package com.itaem.serpit.baselibrary.injection.component

import android.content.Context
import com.itaem.serpit.baselibrary.injection.module.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Administrator on 2018/2/7 0007.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun context():Context
}