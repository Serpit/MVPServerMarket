package com.example.baselibrary.ui.activity

import android.os.Bundle

import com.itaem.serpit.baselibrary.common.AppManager
import com.trello.rxlifecycle.components.support.RxAppCompatActivity

/**
 * Created by Administrator on 2018/1/23 0023.
 */
 open class BaseActivity: RxAppCompatActivity(){
      override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         AppManager.instance.addActivity(this)
      }

 override fun onDestroy() {
  super.onDestroy()
   AppManager.instance.finishActivity(this)
 }
}