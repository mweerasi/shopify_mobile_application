package manju.shopify_mobile_application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private String napoleonSpent = "";
    private int numberOfABB = 0;
    TextView napoleonTextView;
    TextView brownBagsTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //fetch the data and update TextViews
        fetchSpotifyData();
        napoleonTextView = (TextView) findViewById(R.id.napoleon_spent);
        brownBagsTextView = (TextView) findViewById(R.id.number_of_ABB);
        napoleonTextView.setText(napoleonSpent);
        brownBagsTextView.setText(Integer.toString(numberOfABB));
    }



    //implement retrofit to retrive the json and parse with Gson
    public void fetchSpotifyData(){
        String url = "https://shopicruit.myshopify.com/admin/orders.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6";
        ((MobileApplication)getApplicationContext()).getShopifyRestClient().getApi().getOrders("1", "c32313df0d0ef512ca64d5b336a0d7c6").enqueue(new Callback<OrderResponse>() {
            @Override
            public void onResponse(Call<OrderResponse> call, retrofit2.Response<OrderResponse> response) {
                //response.body() = list of Orders
                Log.d(TAG, response.toString());
                for(int i = 0; i < response.body().orders.size(); i++) {
                    if (response.body().orders.get(i).customer != null) {
                        Log.d(TAG, Long.toString(response.body().orders.get(i).customer.getId()));
                        if (response.body().orders.get(i).customer.getId() == 4953626051L) { //Napoleon's customer ID?
                            Log.d(TAG, response.body().orders.get(i).customer.getTotalSpent() + " total spent");
                            napoleonSpent = response.body().orders.get(i).customer.getTotalSpent();
                        }
                    }
                    if (response.body().orders.get(i).lineItems != null) {
                        for (int j = 0; j < response.body().orders.get(i).lineItems.size(); j++) {
                            if (response.body().orders.get(i).lineItems.get(j).productId == 2759139395L) { //Bronze Bag's product ID?
                                numberOfABB++;
                            }
                        }
                    }
                }
                napoleonTextView.setText("$" + napoleonSpent);
                brownBagsTextView.setText(Integer.toString(numberOfABB));
            }

            @Override
            public void onFailure(Call<OrderResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
