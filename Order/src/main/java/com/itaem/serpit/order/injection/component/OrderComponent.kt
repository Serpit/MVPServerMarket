package com.itaem.serpit.order.injection.component

import com.itaem.serpit.baselibrary.injection.PerCommonScope
import com.itaem.serpit.baselibrary.injection.component.ActivityComponent
import com.itaem.serpit.order.injection.module.OrderModule
import com.itaem.serpit.order.ui.activity.*
import dagger.Component

/**
 * Created by Administrator on 2018/2/14 0014.
 */

@PerCommonScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(OrderModule::class))
interface OrderComponent {
   fun inject(activity:ShopDetailActivity)
   fun inject(activity:SettlementActivity)
   fun inject(activity:SetMsgActivity)
   fun inject(activity:MyShopActivity)
   fun inject(activity:MyTeamBuyActivity)
   fun inject(activity:ShopTeamBuyInfoActivity)
   fun inject(activity:AddShopTeamBuyActivity)
   fun inject(activity: ChoseGoodActivity)
}