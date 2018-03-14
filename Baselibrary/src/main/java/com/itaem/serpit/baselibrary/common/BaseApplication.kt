package com.itaem.serpit.baselibrary.common

import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import com.itaem.serpit.baselibrary.injection.component.AppComponent
import com.itaem.serpit.baselibrary.injection.component.DaggerAppComponent
import com.itaem.serpit.baselibrary.injection.module.AppModule

/**
 * Created by Administrator on 2018/2/7 0007.
 */
class BaseApplication : Application() {
    companion object {
        lateinit var context:Context
    }
    lateinit var appComponent:AppComponent
    override fun onCreate() {
        super.onCreate()
        initAppInjection()
                  // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)


        ARouter.init(this)
        context = this
    }

    private fun initAppInjection() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }


}