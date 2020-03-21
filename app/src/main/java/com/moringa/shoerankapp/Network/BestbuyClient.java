package com.moringa.shoerankapp.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.moringa.shoerankapp.Models.Constants.BESTBUY_BASE_URL;

public class BestbuyClient {
    private static Retrofit retrofit = null;

    public static BestbuyApi getClient() {

        if (retrofit == null) {

            retrofit = new Retrofit.Builder()
                    .baseUrl(BESTBUY_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(BestbuyApi.class);
    }
}