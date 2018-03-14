package com.itaem.serpit.order.ui.adapter

import android.content.Context
import android.graphics.Paint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.itaem.serpit.mvpservicemarket.order.R
import com.itaem.serpit.order.data.bean.TeamBuyItem
import com.kotlin.base.ui.adapter.BaseRecyclerViewAdapter
import com.kotlin.base.utils.GlideUtils
import kotlinx.android.synthetic.main.item_my_team_buy.view.*


/**
 *团购列表Adapter
 */
class MyTeamBuyListAdapter constructor( mContext:Context)  : BaseRecyclerViewAdapter<TeamBuyItem, MyTeamBuyListAdapter.ViewHolder>(mContext) {



    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view =LayoutInflater.from(mContext).inflate(R.layout.item_my_team_buy,parent,false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        val module = dataList[position]

        GlideUtils.loadUrlImage(mContext,module.shopLogo, holder.itemView.mShopLogoIv)
        holder.itemView.mOriginPriceTv.paint.flags = Paint.STRIKE_THRU_TEXT_FLAG
        holder.itemView.mGoodNameTv.text = module.name
        holder.itemView.mEndTimeTv.text = module.endTime

        holder.itemView.mCurrentPriceTv.text = "￥${module.groupPrice}"
        holder.itemView.mOriginPriceTv.text = "￥${module.originalPrice}"
    }



    class ViewHolder(view: View):RecyclerView.ViewHolder(view)
}