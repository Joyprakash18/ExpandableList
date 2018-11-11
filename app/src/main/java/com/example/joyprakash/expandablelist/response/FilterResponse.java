package com.example.joyprakash.expandablelist.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FilterResponse {
    @SerializedName("result")
    @Expose
    private String result;
    @SerializedName("investmentOpportunitiesFilterData")
    @Expose
    private List<FilterListModel> investmentOpportunitiesFilterData = null;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<FilterListModel> getInvestmentOpportunitiesFilterData() {
        return investmentOpportunitiesFilterData;
    }

    public void setInvestmentOpportunitiesFilterData(List<FilterListModel> investmentOpportunitiesFilterData) {
        this.investmentOpportunitiesFilterData = investmentOpportunitiesFilterData;
    }

}
