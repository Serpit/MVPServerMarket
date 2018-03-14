package com.itaem.serpit.order.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.itaem.serpit.mvpservicemarket.order.R
import com.itaem.serpit.order.data.protocol.ShopInfo
import com.kotlin.base.ui.adapter.BaseRecyclerViewAdapter
import com.kotlin.base.utils.GlideUtils
import kotlinx.android.synthetic.main.item_shop.view.*

/**
 *商店列表Adapter
 */
class ShopListAdapter constructor(mContext:Context)  : BaseRecyclerViewAdapter<ShopInfo, ShopListAdapter.ViewHolder>(mContext) {



    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view =LayoutInflater.from(mContext).inflate(R.layout.item_shop,parent,false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        val module = dataList[position]

        GlideUtils.loadImage(mContext,module.pic,holder.itemView.mShopPicIv)
        holder.itemView.mShopName.text = module.name
        holder.itemView.mStarGradedView.setStar(module.satisfaction.toFloat())
        holder.itemView.mTypeTv.text = module.type
        holder.itemView.mSatisfactiontV.text = "${module.satisfaction.toFloat()}"

    }



    class ViewHolder(view: View):RecyclerView.ViewHolder(view)
}