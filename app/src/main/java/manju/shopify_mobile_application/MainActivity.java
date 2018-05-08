package manju.shopify_mobile_application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

import manju.shopify_mobile_application.Adapters.OrdersAdapter;
import manju.shopify_mobile_application.Helpers.RecyclerItemClickListener;
import manju.shopify_mobile_application.Parsers.Order;
import manju.shopify_mobile_application.Parsers.OrderResponse;
import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private RecyclerView list;
    private OrdersAdapter ordersAdapter = new OrdersAdapter();
    private TreeMap<String, List<Order>> ordersMap = new TreeMap<>();
    private TreeMap<Integer, List<Order>> yearMap = new TreeMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        fetchShopifyData();
        list = (RecyclerView) findViewById(R.id.list_view);
        list.setLayoutManager(new LinearLayoutManager(this));
        ordersAdapter = new OrdersAdapter();
        list.setAdapter(ordersAdapter);

        list.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), list ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Intent myIntent = new Intent(MainActivity.this, ProvinceActivity.class);
                        myIntent.putExtra("orders", ordersMap);
                        MainActivity.this.startActivity(myIntent);
                    }

                    @Override public void onLongItemClick(View view, int position) { }
                })
        );
    }


    public void fetchShopifyData() {
        //url = "https://shopicruit.myshopify.com/admin/orders.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6"

        ShopifyRestClient.getInstance().getApi().getOrders("1", "c32313df0d0ef512ca64d5b336a0d7c6").enqueue(new Callback<OrderResponse>() {
            @Override
            public void onResponse(Call<OrderResponse> call, retrofit2.Response<OrderResponse> response) {
                //response.body() = list of Orders
                List<Order> orders = response.body().orders;

                // sort the orders by province
                Collections.sort(orders, new Comparator<Order>() {
                    @Override
                    public int compare(Order o1, Order o2) {
                        String p1 = o1.billingAddress != null ? o1.billingAddress.province : "Unspecified";
                        String p2 = o2.billingAddress != null ? o2.billingAddress.province : "Unspecified";
                        return p1.compareToIgnoreCase(p2);
                    }
                });

                for (Order order : orders) {
                    String p1 = order.billingAddress != null ? order.billingAddress.province : "Unspecified";
                    if (!ordersMap.containsKey(p1)) {
                        ordersMap.put(p1, new ArrayList<Order>());
                    }
                    ordersMap.get(p1).add(order);
                }

                Collections.sort(orders, new Comparator<Order>() {
                    @Override
                    public int compare(Order o1, Order o2) {
                        return o2.getYear() - o1.getYear();
                    }
                });

                for (Order order : orders) {
                    if (!yearMap.containsKey(order.getYear())) {
                        yearMap.put(order.getYear(), new ArrayList<Order>());
                    }
                    yearMap.get(order.getYear()).add(order);
                }

                ordersAdapter.updateOrderList(ordersMap, yearMap);
            }

            @Override
            public void onFailure(Call<OrderResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}