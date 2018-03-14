package com.itaem.serpit.order.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.baselibrary.ui.fragment.BaseMvpFragment
import com.itaem.serpit.mvpservicemarket.order.R
import com.itaem.serpit.order.data.protocol.ShopDetail
import com.itaem.serpit.order.injection.component.DaggerOrderFragmentComponent
import com.itaem.serpit.order.injection.module.OrderModule
import com.itaem.serpit.order.presenter.HaveBeenOnPresenter
import com.itaem.serpit.order.presenter.view.HaveBeenOnView
import com.itaem.serpit.order.ui.adapter.GoodManagerListAdapter
import com.itaem.serpit.order.widgets.AddGoodDialog
import kotlinx.android.synthetic.main.fragment_have_been_on.*
import org.jetbrains.anko.support.v4.toast

/**
 * 已上架
 */
class HaveBeenOnFragment :BaseMvpFragment<HaveBeenOnPresenter>(),HaveBeenOnView, View.OnClickListener {
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.mAddGoodRv->{
                AddGoodDialog(mPresenter,activity, R.style.MyDialog,AddGoodDialog.ADD_GOOD).show()
            }

        }
    }

    lateinit var list:List<ShopDetail.DataBean.GoodListBean>
    lateinit var adapter:GoodManagerListAdapter
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         super.onCreateView(inflater, container, savedInstanceState)

         return inflater?.inflate(R.layout.fragment_have_been_on,null)
    }


    override fun onResume() {
        super.onResume()
        initView()
        loadData()
    }

    private fun initView() {
        mAddGoodRv.setOnClickListener(this)
    }


    private fun loadData() {
        adapter = GoodManagerListAdapter(activity,mPresenter)
        mGoodListRv.adapter = adapter
        adapter.setData(list)
    }

     fun setData(list:List<ShopDetail.DataBean.GoodListBean>){
        this.list = list
    }


    override fun onEditSuccess() {
        toast("修改成功")
        mPresenter.loadShopInfo()
    }

    override fun onEditFail() {
        toast("修改失败")
    }

    override fun onCommitSuccess() {
        toast("添加商品成功")
        mPresenter.loadShopInfo()
    }

    override fun onCommitFail() {
        toast("添加商品失败")
    }

    override fun onGetMyGoodResult(list: List<ShopDetail.DataBean.GoodListBean>) {
        adapter.setData(list)
    }

    override fun injectComponent() {
        DaggerOrderFragmentComponent.builder().fragmentComponent(fragmentComponent).orderModule(OrderModule()).build().inject(this)
        mPresenter.mView = this
    }
}