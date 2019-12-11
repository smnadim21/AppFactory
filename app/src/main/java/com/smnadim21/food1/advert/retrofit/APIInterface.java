package com.smnadim21.food1.advert.retrofit;


import com.smnadim21.food1.Contents;
import com.smnadim21.food1.advert.datamodel.Status;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface APIInterface {


    @Headers({"Accept: application/json"})
    @GET("api/sub_check")
    Call<Status> getStatus(@Query("code") String code);

    @Headers({"Accept: application/json"})
    @GET("download")
    Call<String> subscribe(@Query("app_id") String app_id,@Query("file_path") String file_path);



}


