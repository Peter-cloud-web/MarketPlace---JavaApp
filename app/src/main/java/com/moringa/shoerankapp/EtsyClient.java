package com.moringa.shoerankapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.moringa.shoerankapp.Constants.ETSY_BASE_URL;

public class EtsyClient {
    private static Retrofit retrofit = null;

    public static EtsyApi getClient() {

        if (retrofit == null) {

            retrofit = new Retrofit.Builder()
                    .baseUrl(ETSY_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()
                    .build();
        }

        return retrofit.create(EtsyApi.class);
    }
}