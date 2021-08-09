package com.airsen.button.Retrofit;



import com.airsen.button.object.Node;
import com.airsen.button.object.Record;
import com.airsen.button.firebase.UrlInformation;

import java.util.List;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface datasevice {
    @GET("getCurrentAQI")
    Call<List<Node>> Getaqicurrentday();

    @GET("Data7day")
    Call<List<Record>> getDataByNodeId(@Query("Station_id") String Station_id);

    @POST("getdata")
    Call<UrlInformation> GetcreaturlInformation();






}

