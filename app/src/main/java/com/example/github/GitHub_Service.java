package com.example.github;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHub_Service {
    @GET("users/{user}")
    Call<GitHub_User> getUser(@Path("user") String user);
}
