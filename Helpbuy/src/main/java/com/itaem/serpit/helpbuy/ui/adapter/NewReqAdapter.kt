package com.itaem.serpit.helpbuy.ui.adapter

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.itaem.serpit.baselibrary.common.BaseConstant
import com.itaem.serpit.baselibrary.utils.DateUtils
import com.itaem.serpit.helpbuy.data.protocol.AcceptOrderReq
import com.itaem.serpit.helpbuy.data.protocol.Rows
import com.itaem.serpit.helpbuy.presenter.NewReqPresenter
import com.itaem.serpit.mvpservicemarket.helpbuy.R

import com.kotlin.base.ui.adapter.BaseRecyclerViewAdapter
import com.kotlin.base.utils.AppPrefsUtils
import kotlinx.android.synthetic.main.item_new_req.view.*

/**
 *
 */
class NewReqAdapter constructor(mContext:Context, private var mNewReqPresenter: NewReqPresenter)  : BaseRecyclerViewAdapter<Rows,NewReqAdapter.ViewHolder>(mContext) {



    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view =LayoutInflater.from(mContext).inflate(R.layout.item_new_req,parent,false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)

        val module = dataList[position]
        holder.itemView.mArriveTimeTv.text = module.arriveTime
        holder.itemView.mOrderTimeTv.text = module.time
        holder.itemView.mUserNameTv.text = module.username
        holder.itemView.mPhoneTv.text = module.phone
        if ( module.state==1){
           holder.itemView.mStateTv.text = "待接单"
        }else if (module.state == 2){
            holder.itemView.mStateTv.text = "待客户确认中"
            holder.itemView.mOrderReceivingBtn.text = "不可接单"
            holder.itemView.mOrderReceivingBtn.isEnabled = false
            holder.itemView.mOrderReceivingBtn.setTextColor(mContext.resources.getColor(R.color.gray))
        }
        holder.itemView.mPriceTv.text = "${module.price}"
        holder.itemView.mGoodsTv.text = module.listing
        holder.itemView.mAddressTv.text = module.address
        holder.itemView.mOrderReceivingBtn.setOnClickListener({
            //弹框提示
            val builder = AlertDialog.Builder(mContext)
            builder.setPositiveButton("确定",object : DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    //接单
                    mNewReqPresenter.acceptRequest(AcceptOrderReq(DateUtils.format(module.time),
                            AppPrefsUtils.getInt(BaseConstant.KEY_SP_USERID),
                            module.id,module.phone))
                }
            }).setMessage("确定是否要接单").setTitle("提醒")
                    .setNegativeButton("取消",null).show()
        })
    }


    class ViewHolder(view: View):RecyclerView.ViewHolder(view)
}