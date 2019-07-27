package com.beskilled.retropicjsonformate.retrofit;

import com.beskilled.retropicjsonformate.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {
    @GET("posts")
    Call<List<User>> getUser();
}
