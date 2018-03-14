package com.itaem.serpit.order.widgets

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import com.itaem.serpit.baselibrary.common.BaseConstant
import com.itaem.serpit.mvpservicemarket.order.R
import com.itaem.serpit.order.data.protocol.AddGoodReq
import com.itaem.serpit.order.data.protocol.EditGoodReq
import com.itaem.serpit.order.presenter.HaveBeenOnPresenter
import com.kotlin.base.utils.AppPrefsUtils
import kotlinx.android.synthetic.main.dialog_add_good.*

/**
 * 添加商品的信息填写框.
 */
class AddGoodDialog(val presenter: HaveBeenOnPresenter, context: Context?,themeId:Int,val confirmCode:Int) : Dialog(context,themeId), View.OnClickListener {

    var goodID:Int = 0
    companion object {
        const val EDIT_GOOD = 1
        const val ADD_GOOD = 2
    }
    override fun onClick(v: View?) {
        when(v?.id){

            R.id.mConfirmBt->{
                if (confirmCode== EDIT_GOOD){
                    presenter.editGoodCommit(EditGoodReq(goodID,1,mGoodNameEt.text.toString(),mGoodNumberEt.text.toString().toInt()
                            ,"",mGoodPriceEt.text.toString().toInt(),AppPrefsUtils.getInt(BaseConstant.KEY_SP_SHOP_ID)))
                }else if (confirmCode== ADD_GOOD){
                    presenter.addGood(AddGoodReq(1,mGoodNameEt.text.toString(),mGoodNumberEt.text.toString().toInt()
                            ,"",mGoodPriceEt.text.toString().toInt(),AppPrefsUtils.getInt(BaseConstant.KEY_SP_SHOP_ID)))
                }

                this.dismiss()
            }
            R.id.mCancelBt->{
                this.dismiss()
            }
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_good)
        initView()

    }

    private fun initView() {
        if (confirmCode == EDIT_GOOD){
            mTitleText.text = "修改商品信息"
        }
        mCancelBt.setOnClickListener(this)
        mConfirmBt.setOnClickListener(this)
    }
}