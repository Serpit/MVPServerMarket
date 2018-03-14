package com.itaem.serpit.baselibrary.injection

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

/**
 * Created by Administrator on 2018/2/7 0007.
 */
@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
annotation class FragmentScope