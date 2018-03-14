package com.itaem.serpit.order.widgets

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import com.itaem.serpit.baselibrary.common.BaseConstant
import com.itaem.serpit.mvpservicemarket.order.R
import com.itaem.serpit.order.data.protocol.JoinGroupReq
import com.itaem.serpit.order.presenter.TeamBuyPresenter
import com.kotlin.base.utils.AppPrefsUtils
import kotlinx.android.synthetic.main.dialog_confirm_join.*


/**
 * 添加商品的信息填写框.
 */
class JoinGroupConfirmDialog(val groupId:Int,val presenter: TeamBuyPresenter, context: Context?, themeId:Int) : Dialog(context,themeId), View.OnClickListener {

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.mConfirmBt->{
                var isDeliver= "否"
                if(mDeliverRBt.isChecked){
                    isDeliver = "是"
                }
                presenter.joinGroup(JoinGroupReq(AppPrefsUtils.getString(BaseConstant.KEY_SP_ADDRESS),
                        groupId,isDeliver,1,AppPrefsUtils.getString(BaseConstant.KEY_SP_PHONE),
                        AppPrefsUtils.getInt(BaseConstant.KEY_SP_USERID)))
                this.dismiss()

            }
            R.id.mCancelBt->{
                this.dismiss()
            }

        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_confirm_join)
        initView()

    }

    private fun initView() {
        mCancelBt.setOnClickListener(this)
        mConfirmBt.setOnClickListener(this)

    }
}