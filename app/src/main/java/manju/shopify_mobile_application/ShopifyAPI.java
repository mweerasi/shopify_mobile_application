package manju.shopify_mobile_application;

import manju.shopify_mobile_application.Parsers.OrderResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Manju on 2017-09-11.
 */

public interface ShopifyAPI {

    @GET("orders.json")
    Call<OrderResponse> getOrders(
            @Query("page") String page,
            @Query("access_token") String accessToken);
}
