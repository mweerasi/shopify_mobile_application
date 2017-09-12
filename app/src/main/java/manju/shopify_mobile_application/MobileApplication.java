package manju.shopify_mobile_application;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Manju on 2017-09-11.
 */

public class MobileApplication extends Application{
    private ShopifyRestClient shopifyRestClient;
    private Gson gson;
    @Override
    public void onCreate() {
        super.onCreate();
        gson = new GsonBuilder().create();
        this.shopifyRestClient = new ShopifyRestClient("", gson);
    }

    public ShopifyRestClient getShopifyRestClient() {
        return shopifyRestClient;
    }
}
