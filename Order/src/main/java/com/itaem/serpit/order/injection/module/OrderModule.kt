package com.itaem.serpit.order.injection.module


import com.itaem.serpit.order.service.OrderService
import com.itaem.serpit.order.service.impl.OrderServiceImpl
import dagger.Module
import dagger.Provides

/**
 * Created by Administrator on 2018/2/14 0014.
 */
@Module
class OrderModule {
   @Provides
   fun providesHelpService(service: OrderServiceImpl):OrderService{
       return service
   }
}