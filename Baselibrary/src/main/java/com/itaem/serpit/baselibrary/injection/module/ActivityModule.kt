package com.itaem.serpit.baselibrary.injection.module

import android.app.Activity
import com.itaem.serpit.baselibrary.injection.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by Administrator on 2018/2/7 0007.
 */
@Module
class ActivityModule(private val activity:Activity) {
    @ActivityScope
    @Provides
    fun providesActivity():Activity{
        return activity
    }
}