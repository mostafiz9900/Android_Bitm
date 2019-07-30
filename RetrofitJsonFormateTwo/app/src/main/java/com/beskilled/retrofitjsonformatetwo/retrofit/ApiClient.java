package com.beskilled.retrofitjsonformatetwo.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL="https://jsonplaceholder.typicode.com/";
    private static ApiClient mInstanse;
    private Retrofit retrofit;

    public ApiClient() {
        retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static ApiClient getInstanse(){
        if (mInstanse==null){
            mInstanse=new ApiClient();
        }


        return mInstanse;

    }
    public RetrofitInterface getApi(){
        return retrofit.create(RetrofitInterface.class);
    }

}
