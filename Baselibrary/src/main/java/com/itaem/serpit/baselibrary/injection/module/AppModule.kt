package com.itaem.serpit.baselibrary.injection.module

import android.content.Context
import com.itaem.serpit.baselibrary.common.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Administrator on 2018/2/7 0007.
 */
@Module
class AppModule(private val context: BaseApplication) {
    @Provides
    @Singleton
    fun providesContext():Context{
        return context
    }
}