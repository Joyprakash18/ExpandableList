package com.example.joyprakash.expandablelist;

import com.example.joyprakash.expandablelist.response.FilterResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
    @GET("/bins/yv2im")
    Call<FilterResponse> getFilterList();
}
