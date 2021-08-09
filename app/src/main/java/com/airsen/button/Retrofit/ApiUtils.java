package com.airsen.button.Retrofit;

public class ApiUtils {
    public static final String BASE_API = "http://airsense.vn/";
    public static datasevice getService() {
        return APIretrofitclient.getClient(BASE_API).create(datasevice.class);
    }
}
