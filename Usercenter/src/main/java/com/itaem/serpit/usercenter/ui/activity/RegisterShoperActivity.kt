package com.itaem.serpit.usercenter.ui.activity

import android.Manifest
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.util.Log
import com.bumptech.glide.Glide
import com.itaem.serpit.baselibrary.common.BaseConstant
import com.itaem.serpit.baselibrary.ext.onClick
import com.itaem.serpit.baselibrary.ui.activity.BaseTakePhotoActivity
import com.itaem.serpit.mvpservicemarket.usercenter.R
import com.itaem.serpit.usercenter.data.protocol.RegisterShoperReq
import com.itaem.serpit.usercenter.injection.component.DaggerUserComponent
import com.itaem.serpit.usercenter.injection.module.UserModule
import com.itaem.serpit.usercenter.presenter.RegisterShoperPresenter
import com.itaem.serpit.usercenter.presenter.view.RegisterShoperView
import com.jph.takephoto.model.TResult
import com.kotlin.base.utils.AppPrefsUtils
import com.kotlin.base.utils.GlideUtils
import kotlinx.android.synthetic.main.activity_register_shoper.*
import org.jetbrains.anko.toast
import java.io.File

/*
* 注册成为商家*/
class RegisterShoperActivity : BaseTakePhotoActivity<RegisterShoperPresenter>(), RegisterShoperView {

    private var mLocalFile: String? = null


    private lateinit var mTempFile: File
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_register_shoper)
        ActivityCompat.requestPermissions(this@RegisterShoperActivity, arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE), 1)


        initView()
    }

    private fun initView() {
        Glide.with(this).load(AppPrefsUtils.getString(BaseConstant.KEY_SP_SHOP_LOGO)).placeholder(R.mipmap.shop_default).error(R.mipmap.shop_default).centerCrop().into(mShopImgIv)
       mChosePhotoRL.onClick { showAlertView() }
        mHeaderBar.getRightView().onClick {
                    if(!AppPrefsUtils.getBoolean(BaseConstant.KEY_SP_SHOPPER)){
                        mPresenter.toBeShoper(RegisterShoperReq(mAdressEt.text.toString(),
                                mDesEt.text.toString(),1,mShopNameEt.text.toString(),mNoticeEt.text.toString(),mPhoneEt.text.toString(),mTypeEt.text.toString(),AppPrefsUtils.getInt(BaseConstant.KEY_SP_USERID) ))

                    }else{
                        toast("你已经成为商家，请勿重复注册")
                    }
                }
           }

    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(mActivityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }


    override fun takeSuccess(result: TResult?) {
        mLocalFile = result?.image?.compressPath
        mTempFile = File(mLocalFile)
        mPresenter.uploadImg(mTempFile,1)
        Log.d("mLocalFile",mLocalFile)

    }

    override fun onUploadImgSuccess(url: String) {
        GlideUtils.loadUrlImage(this,url,mShopImgIv)
    }

    override fun onToBeShoperSuccess() {
        toast("恭喜你成为商家")
        finish()
    }

    override fun onToBeShoperFail() {
       toast("成为商家失败，请稍后重试")
    }
}
