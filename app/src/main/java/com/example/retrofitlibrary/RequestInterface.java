package com.example.retrofitlibrary;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {

//    @GET("https://api.github.com/search/users?q=language:java+location:nairobi/")
@GET("search/users?q=language:java+location:nairobi/")
Call<UserData> getJson();
}
