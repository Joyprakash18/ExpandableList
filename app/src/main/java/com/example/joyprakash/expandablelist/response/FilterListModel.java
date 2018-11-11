package com.example.joyprakash.expandablelist.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FilterListModel {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("subItemList")
    @Expose
    private List<FilterSubListModel> subItemList = null;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<FilterSubListModel> getSubItemList() {
        return subItemList;
    }

    public void setSubItemList(List<FilterSubListModel> subItemList) {
        this.subItemList = subItemList;
    }

}
