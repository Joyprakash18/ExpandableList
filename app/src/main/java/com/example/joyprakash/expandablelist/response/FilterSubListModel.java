package com.example.joyprakash.expandablelist.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FilterSubListModel {
    @SerializedName("flag")
    @Expose
    private String flag;
    @SerializedName("item")
    @Expose
    private String item;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

}
