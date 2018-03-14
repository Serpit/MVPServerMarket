package com.itaem.serpit.order.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.itaem.serpit.mvpservicemarket.order.R
import com.itaem.serpit.order.data.protocol.ShopDetail
import com.itaem.serpit.order.presenter.HaveBeenOnPresenter
import com.itaem.serpit.order.widgets.AddGoodDialog
import com.kotlin.base.ui.adapter.BaseRecyclerViewAdapter
import com.kotlin.base.utils.GlideUtils
import kotlinx.android.synthetic.main.good_manage_item.view.*


/**
 *已经上架列表Adapter
 */
class GoodManagerListAdapter constructor(mContext:Context,val presenter: HaveBeenOnPresenter)  : BaseRecyclerViewAdapter<ShopDetail.DataBean.GoodListBean, GoodManagerListAdapter.ViewHolder>(mContext) {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view =LayoutInflater.from(mContext).inflate(R.layout.good_manage_item,parent,false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        val module = dataList[position]
        holder.itemView.mEditIv.setOnClickListener {
            val dialog = AddGoodDialog(presenter,mContext,R.style.MyDialog,AddGoodDialog.EDIT_GOOD)
                    dialog.goodID = module.goodId
                    dialog.show() }
        holder.itemView.mGoodNameTv.text = module.name
        holder.itemView.mNumTv.text = "余量${module.number}"
        holder.itemView.mPriceTv.text = "￥${module.price}"
        GlideUtils.loadUrlImage(mContext,module.img,holder.itemView.mGoodIv)

    }



    class ViewHolder(view: View):RecyclerView.ViewHolder(view)
}