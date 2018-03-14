package com.itaem.serpit.usercenter.ui.activity

import android.os.Bundle
import android.util.Log
import com.example.baselibrary.ui.activity.BaseMvpActivity
import com.itaem.serpit.baselibrary.ext.onClick
import com.itaem.serpit.mvpservicemarket.usercenter.R


import com.itaem.serpit.usercenter.injection.component.DaggerUserComponent
import com.itaem.serpit.usercenter.injection.module.UserModule
import com.itaem.serpit.usercenter.presenter.RegisterPresenter
import com.itaem.serpit.usercenter.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast
class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mRegisterBtn.onClick {
            mPresenter.register(mUserEt.text.toString(),mPwEt.text.toString(),mAddressEt.text.toString(),mPhoneEt.text.toString())
        }
    }

    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }



    override fun registerResult(result:String) {
        Log.d("RESULT",result)
        if (result=="true"){
            toast("注册成功")
            finish()
        }else{
            toast("注册失败")
        }
    }
}
