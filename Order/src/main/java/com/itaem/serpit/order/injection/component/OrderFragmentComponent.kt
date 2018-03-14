package com.itaem.serpit.order.injection.component

import com.itaem.serpit.baselibrary.injection.PerCommonScope
import com.itaem.serpit.baselibrary.injection.component.FragmentComponent
import com.itaem.serpit.order.injection.module.OrderModule
import com.itaem.serpit.order.ui.fragment.HaveBeenOnFragment
import com.itaem.serpit.order.ui.fragment.MainFragment
import com.itaem.serpit.order.ui.fragment.TeamBuyFragment
import dagger.Component

/**
 * Created by Administrator on 2018/2/20 0020.
 */
@PerCommonScope
@Component(modules = arrayOf(OrderModule::class),dependencies = arrayOf(FragmentComponent::class))
interface OrderFragmentComponent {
    fun inject(fragment: MainFragment)
    fun inject(fragment: HaveBeenOnFragment)
    fun inject(fragment: TeamBuyFragment)
}