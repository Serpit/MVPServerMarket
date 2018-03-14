package com.itaem.serpit.helpbuy.data.protocol;

import com.itaem.serpit.helpbuy.data.bean.State;

import java.util.Date;

/**
 * Created by Administrator on 2018/2/22 0022.
 */

public  class Data {
    private int id;

    private int helperId;

    private int helperTableId;

    private String deadTime;

    private String acceptTime;

    private String phone;

    private int state;

    private HelperTable helperTable;

    private State stateVo;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setHelperId(int helperId){
        this.helperId = helperId;
    }
    public int getHelperId(){
        return this.helperId;
    }
    public void setHelperTableId(int helperTableId){
        this.helperTableId = helperTableId;
    }
    public int getHelperTableId(){
        return this.helperTableId;
    }
    public void setDeadTime(String deadTime){
        this.deadTime = deadTime;
    }
    public String getDeadTime(){
        return this.deadTime;
    }
    public void setAcceptTime(String acceptTime){
        this.acceptTime = acceptTime;
    }
    public String getAcceptTime(){
        return this.acceptTime;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getPhone(){
        return this.phone;
    }
    public void setState(int state){
        this.state = state;
    }
    public int getState(){
        return this.state;
    }
    public void setHelperTable(HelperTable helperTable){
        this.helperTable = helperTable;
    }
    public HelperTable getHelperTable(){
        return this.helperTable;
    }

    public State getStateVo() {
        return stateVo;
    }

    public void setStateVo(State stateVo) {
        this.stateVo = stateVo;
    }
}