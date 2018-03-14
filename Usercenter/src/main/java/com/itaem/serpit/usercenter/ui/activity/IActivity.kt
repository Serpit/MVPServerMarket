package com.itaem.serpit.usercenter.ui.activity


import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.itaem.serpit.baselibrary.common.BaseConstant
import com.itaem.serpit.baselibrary.ext.onClick
import com.itaem.serpit.baselibrary.ui.activity.BaseTakePhotoActivity
import com.itaem.serpit.mvpservicemarket.usercenter.R
import com.itaem.serpit.usercenter.injection.component.DaggerUserComponent
import com.itaem.serpit.usercenter.injection.module.UserModule
import com.itaem.serpit.usercenter.presenter.IPresenter
import com.itaem.serpit.usercenter.presenter.view.IView
import com.jph.takephoto.model.TResult
import com.kotlin.base.utils.AppPrefsUtils
import com.kotlin.base.utils.GlideUtils
import kotlinx.android.synthetic.main.activity_i.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import java.io.File

@Route(path = "/userCenter/IActivity")
class IActivity : BaseTakePhotoActivity<IPresenter>(), IView, View.OnClickListener {

    private var mLocalFile: String? = null


    private lateinit var mTempFile: File
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_i)


        initView()
    }

    private fun initView() {
        if(!AppPrefsUtils.getBoolean(BaseConstant.KEY_SP_IS_LOGIN)){
            mLoginViewLL.visibility = View.VISIBLE
            mContentLL.visibility = View.GONE
            mLoginOutBt.visibility = View.GONE
            mLoginViewLL.onClick {
                startActivity<LoginActivity>()
                finish()
            }

        }else{
            mLoginOutBt.visibility = View.VISIBLE
            mLoginViewLL.visibility = View.GONE
            mContentLL.visibility = View.VISIBLE
            loadData()

            mUserImgIv.setOnClickListener(this)
            mLoginOutBt.setOnClickListener(this)
            iv_exit.setOnClickListener(this)
            mMyMsgLL.setOnClickListener(this)
            mMyOrderLL.setOnClickListener(this)
            mMyShopCarLL.setOnClickListener(this)
           /* mMyHelpBuyLL.setOnClickListener(this)*/
            mMyTeamBuyLL.setOnClickListener(this)
            mHelpBuyMsgLL.setOnClickListener(this)
            mTeamBuyMsgLL.setOnClickListener(this)
            mEditMyMsgIv.setOnClickListener(this)
        }


    }

    override fun onResume() {
        super.onResume()
        GlideUtils.loadUrlImage(this,AppPrefsUtils.getString(BaseConstant.KEY_SP_USER_IMG),mUserImgIv)
    }
    override fun takeSuccess(result: TResult?) {
        mLocalFile = result?.image?.compressPath
        mTempFile = File(mLocalFile)
        mPresenter.uploadImg(mTempFile)
        Log.d("mLocalFile",mLocalFile)

    }
    private fun loadData() {
        GlideUtils.loadUrlImage(this,AppPrefsUtils.getString(BaseConstant.KEY_SP_PICTURE),mUserImgIv)
        mUserNameTv.text = AppPrefsUtils.getString(BaseConstant.KEY_SP_USERNAME)
        mPhoneTv.text = AppPrefsUtils.getString(BaseConstant.KEY_SP_PHONE)
    }

    override fun uploadImgSuccess(url:String) {
        toast("上传成功")
        GlideUtils.loadUrlImage(this,url,mUserImgIv)
    }

    override fun uploadImgFailed() {
        toast("上传失败")
    }

    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(mActivityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }


    override fun onClick(v: View?) {
        when(v?.id){
            R.id.mUserImgIv->{
                showAlertView()
            }
            R.id.iv_exit->{finish()}
            R.id.mMyMsgLL->{toast("暂时未开通该功能，敬请期待")}
            R.id.mMyOrderLL->{toast("暂时未开通该功能，敬请期待")}
            R.id.mMyShopCarLL->{toast("暂时未开通该功能，敬请期待")}
            R.id.mLoginOutBt->{
                val builder = AlertDialog.Builder(this)
                builder.setPositiveButton("确定",object :DialogInterface.OnClickListener{
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        mPresenter.logout()
                        finish()
                    }
                }).setMessage("你确定要退出吗").setTitle("提醒")
                        .setNegativeButton("取消",null)
                        .show()

            }
            R.id.mMyTeamBuyLL->{
                ARouter.getInstance().build("/Order/MyTeamBuyActivity").navigation()
                finish()
            }
            R.id.mHelpBuyMsgLL->{
                //若用户没成为代购者则需要先成为代购者
                if(!AppPrefsUtils.getBoolean(BaseConstant.KEY_SP_HELPER)){
                    val builder = AlertDialog.Builder(this)
                    builder.setPositiveButton("确定",object :DialogInterface.OnClickListener{
                        override fun onClick(dialog: DialogInterface?, which: Int) {
                            //成为代购者
                            mPresenter.toBeHelper(AppPrefsUtils.getInt(BaseConstant.KEY_SP_USERID))
                        }
                    }).setMessage("您还没成为代购者，是否现在申请").setTitle("提醒")
                            .setNegativeButton("取消",null)
                            .show()

                }else{
                    ARouter.getInstance().build("/HelpBuy/HelpBuyMsgActivity").navigation()
                }
            }
            R.id.mTeamBuyMsgLL->{
                if(AppPrefsUtils.getBoolean(BaseConstant.KEY_SP_SHOPPER)){
                    ARouter.getInstance().build("/Order/MyShopActivity").navigation()

                }else{
                    val builder = AlertDialog.Builder(this)
                    builder.setPositiveButton("确定",object :DialogInterface.OnClickListener{
                        override fun onClick(dialog: DialogInterface?, which: Int) {
                            startActivity<RegisterShoperActivity>()
                        }
                    }).setMessage("您还没成为商家，是否现在申请").setTitle("提醒")
                            .setNegativeButton("取消",null)
                            .show()
                }

            }
            R.id.mEditMyMsgIv->{
                toast("暂不支持修改信息")
            }
        }
    }

    override fun onLogout() {
        toast("退出成功")
    }

    override fun onToBeHelperResult(t: Boolean) {
       
        if (t){
            AppPrefsUtils.putBoolean(BaseConstant.KEY_SP_HELPER,t)

        }
    }
}
