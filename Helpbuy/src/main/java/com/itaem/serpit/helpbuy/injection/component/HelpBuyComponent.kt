package com.itaem.serpit.helpbuy.injection.component

import com.itaem.serpit.baselibrary.injection.PerCommonScope
import com.itaem.serpit.baselibrary.injection.component.ActivityComponent
import com.itaem.serpit.baselibrary.injection.component.FragmentComponent
import com.itaem.serpit.helpbuy.injection.module.HelpBuyModule
import com.itaem.serpit.helpbuy.service.HelpBuyService
import com.itaem.serpit.helpbuy.service.impl.HelpBuyServiceImpl
import com.itaem.serpit.helpbuy.ui.activity.HelpBuyMsgActivity
import com.itaem.serpit.helpbuy.ui.activity.HelpBuyReqActivity
import com.itaem.serpit.helpbuy.ui.activity.RequestDetailActivity
import com.itaem.serpit.helpbuy.ui.fragment.NewReqFragment
import dagger.Component
import dagger.Provides
import javax.inject.Inject

/**
 * Created by Administrator on 2018/2/14 0014.
 */

@PerCommonScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(HelpBuyModule::class))
interface HelpBuyComponent {
    fun inject(activity:HelpBuyMsgActivity)
    fun inject(activity:RequestDetailActivity)
    fun inject(activity:HelpBuyReqActivity)
  //  fun inject(fragment:NewReqFragment)
}