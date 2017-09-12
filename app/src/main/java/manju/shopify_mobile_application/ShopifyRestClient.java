package manju.shopify_mobile_application;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Manju on 2017-09-11.
 */

public class ShopifyRestClient {
    private static final String baseURL = "https://shopicruit.myshopify.com/admin/";
    private String accessToken;
    private ShopifyAPI api;
    private Gson gson;
    public ShopifyRestClient(String accessToken, Gson gson){
        this.accessToken = accessToken;
        this.gson = gson; //parser by Google
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(baseURL)
                .build();
        this.api = retrofit.create(ShopifyAPI.class);
    }

    public ShopifyAPI getApi() {
        return api;
    }
}
