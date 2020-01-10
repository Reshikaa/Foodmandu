package com.reshika.foodmandu.api;

import com.reshika.foodmandu.model.Alcohol;
import com.reshika.foodmandu.model.Detail;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AlcoholApi {

    @GET("alcohol")
    Call<List<Alcohol>> getAlcohol();

}
