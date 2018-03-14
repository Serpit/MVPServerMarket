package com.itaem.serpit.usercenter.injection.module


import com.itaem.serpit.usercenter.service.UserService
import com.itaem.serpit.usercenter.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides

/*这里参数里面的UserServiceImpl会去找UserServiceImpl里面有没有相对应的Inject来构造它*/

@Module
class UserModule {
    @Provides
    fun providesUserService(service: UserServiceImpl): UserService {
        return service
    }
}