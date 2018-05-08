package manju.shopify_mobile_application;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import manju.shopify_mobile_application.Adapters.OrdersAdapter;
import manju.shopify_mobile_application.Parsers.Order;


public class ProvinceActivity extends AppCompatActivity {
    private RecyclerView ordersList;
    private OrdersAdapter ordersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TreeMap<String, List<Order>> ordersMap = new TreeMap<>((Map<String, List<Order>>) getIntent().getSerializableExtra("orders"));

        setContentView(R.layout.activity_province);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //fetch the data and update TextViews
        ordersList = (RecyclerView) findViewById(R.id.orders_list);
        ordersList.setLayoutManager(new LinearLayoutManager(this));
        ordersAdapter = new OrdersAdapter();
        ordersList.setAdapter(ordersAdapter);
        ordersAdapter.updateProvinceList(ordersMap);
    }
}
