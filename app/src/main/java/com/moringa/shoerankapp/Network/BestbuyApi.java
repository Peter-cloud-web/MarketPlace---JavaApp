package com.moringa.shoerankapp.Network;

import com.moringa.shoerankapp.Models.BestBuyProductSearchResponse;
import com.moringa.shoerankapp.Models.BestbuyCategoriesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BestbuyApi {

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
