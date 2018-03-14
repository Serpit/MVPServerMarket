package com.itaem.serpit.helpbuy.data.protocol;

import com.itaem.serpit.helpbuy.data.bean.Accepter;
import com.itaem.serpit.helpbuy.data.bean.State;

import java.util.List;

/**
 * Created by Administrator on 2018/2/23 0023.
 */

public class HelperTable {
    private int id;

    private int userId;

    private String listing;

    private String address;

    private String arriveTime;

    private String phone;

    private int price;

    private String time;

    private int state;

    private String username;

    private State stateVo;

    private List<Accepter> accepterVoList;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setUserId(int userId){
        this.userId = userId;
    }
    public int getUserId(){
        return this.userId;
    }
    public void setListing(String listing){
        this.listing = listing;
    }
    public String getListing(){
        return this.listing;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return this.address;
    }
    public void setArriveTime(String arriveTime){
        this.arriveTime = arriveTime;
    }
    public String getArriveTime(){
        return this.arriveTime;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getPhone(){
        return this.phone;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public int getPrice(){
        return this.price;
    }
    public void setTime(String time){
        this.time = time;
    }
    public String getTime(){
        return this.time;
    }
    public void setState(int state){
        this.state = state;
    }
    public int getState(){
        return this.state;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return this.username;
    }

    public State getStateVo() {
        return stateVo;
    }

    public void setStateVo(State stateVo) {
        this.stateVo = stateVo;
    }

    public List<Accepter> getAccepterVoList() {
        return accepterVoList;
    }

    public void setAccepterVoList(List<Accepter> accepterVoList) {
        this.accepterVoList = accepterVoList;
    }
}





