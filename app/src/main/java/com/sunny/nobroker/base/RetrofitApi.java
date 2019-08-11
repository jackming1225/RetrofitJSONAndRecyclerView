package com.sunny.nobroker.base;


import com.sunny.nobroker.model.MyResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitApi {

    @GET("5d3a99ed2f0000bac16ec13a")
    Call<MyResponse> getPropertyList();
}
