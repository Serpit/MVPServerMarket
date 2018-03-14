package com.itaem.serpit.order.data.bean;


import java.io.Serializable;

public class Good  implements Serializable{
    private int goodId;
    private String name;
    private int price;
    private String img;
    private int number;
    private int num = 0;

    public Good(int goodId, String name, int price, String img, int number) {
        this.goodId = goodId;
        this.name = name;
        this.price = price;
        this.img = img;
        this.number = number;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
