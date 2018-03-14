package com.itaem.serpit.usercenter.injection.component

import com.itaem.serpit.baselibrary.injection.PerCommonScope
import com.itaem.serpit.baselibrary.injection.component.ActivityComponent
import com.itaem.serpit.usercenter.injection.module.UserModule
import com.itaem.serpit.usercenter.ui.activity.IActivity
import com.itaem.serpit.usercenter.ui.activity.LoginActivity
import com.itaem.serpit.usercenter.ui.activity.RegisterActivity
import com.itaem.serpit.usercenter.ui.activity.RegisterShoperActivity
import dagger.Component

/**
 * Created by Administrator on 2018/2/8 0008.
 */
@PerCommonScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(UserModule::class))
interface UserComponent {
    fun inject(activity: RegisterActivity)
    fun inject(activity: LoginActivity)
    fun inject(activity: IActivity)
    fun inject(activity: RegisterShoperActivity)

}