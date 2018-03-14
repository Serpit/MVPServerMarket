package com.itaem.serpit.helpbuy.data.protocol;

import java.util.List;

/**
 * Created by Administrator on 2018/2/20 0020.
 */


public class HelpBuyRequestInfo {
    private int total;

    private List<Rows> rows;
    public void setTotal(int total) {
        this.total = total;
    }
    public int getTotal() {
        return total;
    }

    public void setRows(List<Rows> rows) {
        this.rows = rows;
    }
    public List<Rows> getRows() {
        return rows;
    }
}
