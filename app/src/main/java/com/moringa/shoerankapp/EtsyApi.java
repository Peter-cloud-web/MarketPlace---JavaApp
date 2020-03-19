package com.moringa.shoerankapp;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EtsyApi {

    //products get request
    @GET("products?apiKey=BxaYUpnn8AUTWp69vYwpDi1V&format=json")
    Call<BestBuyProductSearchResponse> getProducts(
//            @Query("api key") String query api_key
    );

    //categories get request
    @GET("categories?apiKey=BxaYUpnn8AUTWp69vYwpDi1V&format=json")
    Call<BestbuyCategoriesResponse> getCategories(
//            @Query("api key") String query api_key
    );
}
