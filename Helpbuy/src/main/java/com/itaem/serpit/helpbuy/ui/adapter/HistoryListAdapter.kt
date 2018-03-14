package com.itaem.serpit.helpbuy.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.itaem.serpit.helpbuy.data.protocol.HelperTable
import com.itaem.serpit.mvpservicemarket.helpbuy.R

import com.kotlin.base.ui.adapter.BaseRecyclerViewAdapter
import kotlinx.android.synthetic.main.item_history_helpbuy.view.*

/**
 *代购历史Adapter
 */
class HistoryListAdapter constructor(mContext:Context)  : BaseRecyclerViewAdapter<HelperTable, HistoryListAdapter.ViewHolder>(mContext) {



    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view =LayoutInflater.from(mContext).inflate(R.layout.item_history_helpbuy,parent,false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        val module = dataList[position]
        when(module.state){
            1 ->  holder.itemView.mStateTv.text = "等待代购者接单中"
            2 -> {
                if(module.accepterVoList[0].state==3) holder.itemView.mStateTv.text = "等待送达"
                if(module.accepterVoList[0].state==2) holder.itemView.mStateTv.text = "已接单,需要您确认"
            }
            3 ->  holder.itemView.mStateTv.text = "等待代购者送单"
        }

        holder.itemView.mGoodNameTv.text = module.listing
        holder.itemView.mArriveTimeTv.text = module.arriveTime


    }


    class ViewHolder(view: View):RecyclerView.ViewHolder(view)
}