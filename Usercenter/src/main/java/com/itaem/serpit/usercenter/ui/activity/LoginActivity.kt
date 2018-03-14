package com.itaem.serpit.usercenter.ui.activity


import android.os.Bundle
import android.view.View
import com.example.baselibrary.ui.activity.BaseMvpActivity
import com.itaem.serpit.mvpservicemarket.usercenter.R
import com.itaem.serpit.usercenter.injection.component.DaggerUserComponent
import com.itaem.serpit.usercenter.injection.module.UserModule
import com.itaem.serpit.usercenter.presenter.LoginPresenter
import com.itaem.serpit.usercenter.presenter.view.LoginView
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast


class LoginActivity : BaseMvpActivity<LoginPresenter>(), LoginView, View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initView()
    }

    private fun initView() {
        mLoginBtn.setOnClickListener(this)
        mForgetPwTv.setOnClickListener(this)
        mRegisterTv.setOnClickListener(this)
    }

    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.mLoginBtn->{mPresenter.login(mCount.text.toString(),mPwEt.text.toString())}
            R.id.mForgetPwTv->{toast("该功能还没开通")}
            R.id.mRegisterTv->{startActivity<RegisterActivity>()}
        }
    }


    override fun login() {
        toast("登陆成功")

        finish()
    }

    override fun loginError() {
        toast("登陆失败")
    }
}
