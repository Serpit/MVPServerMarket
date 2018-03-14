package com.itaem.serpit.helpbuy.injection.module

import com.itaem.serpit.helpbuy.service.HelpBuyService
import com.itaem.serpit.helpbuy.service.impl.HelpBuyServiceImpl
import dagger.Module
import dagger.Provides
import java.util.*

/**
 * Created by Administrator on 2018/2/14 0014.
 */
@Module
class HelpBuyModule{
   @Provides
   fun providesHelpService(service: HelpBuyServiceImpl):HelpBuyService{
       return service
   }
}