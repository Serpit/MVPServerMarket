package com.itaem.serpit.order.data.protocol

import java.io.Serializable

/**
 *  private String name;
private String pic;
private String type;
private String descripe;
private String satisfaction;
private int shopId;
 */
data class ShopInfo(val name:String,
                    val pic:String,
                    val type:String,
                    val descridescripe:String,
                    val satisfaction:String,
                    val shopId:Int) : Serializable