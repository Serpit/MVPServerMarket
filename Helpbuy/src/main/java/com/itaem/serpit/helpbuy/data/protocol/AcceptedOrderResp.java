package com.itaem.serpit.helpbuy.data.protocol;

import java.util.Date;
import java.util.List;


public class AcceptedOrderResp {




        private int status;
        private String msg;
        private List<Data> data;
        public void setStatus(int status) {
            this.status = status;
        }
        public int getStatus() {
            return status;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
        public String getMsg() {
            return msg;
        }

        public void setData(List<Data> data) {
            this.data = data;
        }
        public List<Data> getData() {
            return data;
        }

    }





