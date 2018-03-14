package com.itaem.serpit.baselibrary.injection.module

import android.support.v4.app.Fragment
import com.itaem.serpit.baselibrary.injection.FragmentScope
import dagger.Module
import dagger.Provides

/**
 * Created by Administrator on 2018/2/19 0019.
 */
@Module
class FragmentModule(private val fragment:Fragment) {
    @FragmentScope
    @Provides
    fun providesFragment():Fragment{
        return fragment
    }
}