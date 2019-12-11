package com.smnadim21.food1.advert.retrofit;


import com.smnadim21.food1.Contents;
import com.smnadim21.food1.advert.datamodel.Status;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface FactoryAPIInterface {




    @Headers({"Accept: application/json"})
    @GET("/api/contents")
    Call<Contents> getcontent(@Query("key") String key);


}


