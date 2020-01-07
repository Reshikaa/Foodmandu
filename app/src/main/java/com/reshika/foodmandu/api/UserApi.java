package com.reshika.foodmandu.api;

import com.reshika.foodmandu.model.User;
import com.reshika.foodmandu.serverresponse.SignUpResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface UserApi {
    @POST("users/signup")
    Call<SignUpResponse> registerUser(@Body User user);

    @FormUrlEncoded
    @POST("users/login")
    Call<SignUpResponse> checkUser(@Field("username") String username, @Field("password") String password);

    @GET("users/me")
    Call<User> getUserDetails(@Header("Authorization")String token);

}
