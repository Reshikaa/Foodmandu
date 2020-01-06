package com.reshika.foodmandu.api;

import com.reshika.foodmandu.model.User;
import com.reshika.foodmandu.serverresponse.SignUpResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserApi {
    @POST("users/signup")
    Call<SignUpResponse> registerUser(@Body User user);
}
