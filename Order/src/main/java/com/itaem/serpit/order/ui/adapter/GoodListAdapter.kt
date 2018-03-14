package com.itaem.serpit.order.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.itaem.serpit.baselibrary.widgets.IncreaseAndReduceView
import com.itaem.serpit.mvpservicemarket.order.R
import com.itaem.serpit.order.data.protocol.ShopDetail
import com.kotlin.base.ui.adapter.BaseRecyclerViewAdapter
import com.kotlin.base.utils.GlideUtils
import kotlinx.android.synthetic.main.good_item.view.*


/**
 *商店列表Adapter
 */
class GoodListAdapter constructor(mContext:Context, modifyListener:IncreaseAndReduceView.ModifyNumberListener)  : BaseRecyclerViewAdapter<ShopDetail.DataBean.GoodListBean, GoodListAdapter.ViewHolder>(mContext) {

    private val modifyListener = modifyListener

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view =LayoutInflater.from(mContext).inflate(R.layout.good_item,parent,false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        val module = dataList[position]
        holder.itemView.increaseSubView.setModifyNumberListener(modifyListener)
        holder.itemView.increaseSubView.setPosition(position)
        holder.itemView.mGoodNameTv.text = module.name
        holder.itemView.mNumTv.text = "余量${module.number}"
        holder.itemView.mPriceTv.text = "￥${module.price}"
        GlideUtils.loadImage(mContext,module.img,holder.itemView.mGoodIv)

    }



    class ViewHolder(view: View):RecyclerView.ViewHolder(view)
}