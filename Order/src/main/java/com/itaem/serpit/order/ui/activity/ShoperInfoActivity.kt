package com.itaem.serpit.order.ui.activity

import android.os.Bundle
import com.example.baselibrary.ui.activity.BaseActivity
import com.itaem.serpit.baselibrary.ext.onClick
import com.itaem.serpit.mvpservicemarket.order.R
import com.itaem.serpit.order.common.Constant
import kotlinx.android.synthetic.main.activity_set_msg.*


/*修改个人订单信息详情*/
class ShoperInfoActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_msg)

        initView()

    }



    private fun initView() {
        mConfirmBt.onClick {
            intent.putExtra("name",mUserEt.text.toString())
            intent.putExtra("phone",mPhoneEt.text.toString())
            intent.putExtra("address",mAddressEt.text.toString())
            setResult(Constant.RESULT_FROM_SET_MSG,intent)
            finish() }
    }












}
