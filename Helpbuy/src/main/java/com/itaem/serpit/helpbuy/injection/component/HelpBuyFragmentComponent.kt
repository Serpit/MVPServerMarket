package com.itaem.serpit.helpbuy.injection.component

import com.itaem.serpit.baselibrary.injection.PerCommonScope
import com.itaem.serpit.baselibrary.injection.component.FragmentComponent
import com.itaem.serpit.helpbuy.injection.module.HelpBuyModule
import com.itaem.serpit.helpbuy.ui.fragment.AcceptedFragment
import com.itaem.serpit.helpbuy.ui.fragment.HelpBuyFragment
import com.itaem.serpit.helpbuy.ui.fragment.NewReqFragment
import dagger.Component

/**
 * Created by Administrator on 2018/2/20 0020.
 */
@PerCommonScope
@Component(modules = arrayOf(HelpBuyModule::class),dependencies = arrayOf(FragmentComponent::class))
interface HelpBuyFragmentComponent {
    fun inject(fragment:NewReqFragment)
    fun inject(fragment:AcceptedFragment)
    fun inject(fragment: HelpBuyFragment)
}