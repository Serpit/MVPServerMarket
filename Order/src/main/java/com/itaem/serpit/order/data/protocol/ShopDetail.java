package com.itaem.serpit.order.data.protocol;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/7 0007.
 */

public class ShopDetail {

    /**
     * status : 200
     * msg : OK
     * data : {"address":"我家门口","phone":"123","notice":"好吃便宜","des":"kdjife","goodList":[{"goodId":1,"name":"小财华","price":23,"img":"ww.jieni","number":89},{"goodId":2,"name":"Leninism","price":34,"img":"ee.w","number":32}]}
     */

    private int status;
    private String msg;
    private DataBean data;

    public static ShopDetail objectFromData(String str) {

        return new Gson().fromJson(str, ShopDetail.class);
    }

    public static ShopDetail objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), ShopDetail.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<ShopDetail> arrayShopDetailBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<ShopDetail>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<ShopDetail> arrayShopDetailBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<ShopDetail>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * address : 我家门口
         * phone : 123
         * notice : 好吃便宜
         * des : kdjife
         * goodList : [{"goodId":1,"name":"小财华","price":23,"img":"ww.jieni","number":89},{"goodId":2,"name":"Leninism","price":34,"img":"ee.w","number":32}]
         */



        private String address;
        private String phone;
        private String notice;
        private String des;
        private List<GoodListBean> goodList;


        public static DataBean objectFromData(String str) {

            return new Gson().fromJson(str, DataBean.class);
        }

        public static DataBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), DataBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<DataBean> arrayDataBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<DataBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<DataBean> arrayDataBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<DataBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getNotice() {
            return notice;
        }

        public void setNotice(String notice) {
            this.notice = notice;
        }

        public String getDes() {
            return des;
        }

        public void setDes(String des) {
            this.des = des;
        }

        public List<GoodListBean> getGoodList() {
            return goodList;
        }

        public void setGoodList(List<GoodListBean> goodList) {
            this.goodList = goodList;
        }

        public static class GoodListBean implements Serializable {
            /**
             * goodId : 1
             * name : 小财华
             * price : 23
             * img : ww.jieni
             * number : 89
             */

            private int goodId;
            private String name;
            private int price;
            private String img;
            private int number;

            public static GoodListBean objectFromData(String str) {

                return new Gson().fromJson(str, GoodListBean.class);
            }

            public static GoodListBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), GoodListBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<GoodListBean> arrayGoodListBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<GoodListBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<GoodListBean> arrayGoodListBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<GoodListBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


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
        }
    }
}
