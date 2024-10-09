package com.example.github;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GitHub_Client {
    private static final String BASE_URL = "https://api.github.com/";

    public static GitHub_Service getGitHubService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(GitHub_Service.class);
    }
}
