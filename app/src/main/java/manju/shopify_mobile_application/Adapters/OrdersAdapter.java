package manju.shopify_mobile_application.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import manju.shopify_mobile_application.Parsers.Order;
import manju.shopify_mobile_application.R;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.BaseHolder> {
    private List<String> data = new ArrayList<>();
    private List<Integer> headerIndices = new ArrayList<>();

    public void updateProvinceList(TreeMap<String, List<Order>> ordersMap) {
        data.clear();

        int counter = 0;
        for (Map.Entry<String, List<Order>> province : ordersMap.entrySet()) {
            headerIndices.add(counter);
            data.add(String.format("%s", province.getKey()));
            for (Order order : province.getValue()) {
                data.add("\t - Order ID: " + String.valueOf(order.id));
                counter++;
            }
            counter++;
        }
        notifyDataSetChanged();
    }

    public void updateOrderList(TreeMap<String, List<Order>> ordersMap, TreeMap<Integer, List<Order>> yearMap) {
        data.clear();

        int counter = 0;
        headerIndices.add(counter);
        data.add("Orders By Province");
        for (Map.Entry<String, List<Order>> province : ordersMap.entrySet()) {
            data.add(String.format("\t %d orders from %s", province.getValue().size(), province.getKey()));
            counter++;
        }
        counter++;

        data.add("\n");
        counter++;

        headerIndices.add(counter);
        data.add("Orders By Year");
        for (Map.Entry<Integer, List<Order>> year : yearMap.entrySet()) {
            data.add(String.format("\t %d orders from %d", year.getValue().size(), year.getKey()));
            for (int i = 0; i < Math.min(10, year.getValue().size()); i++) {
                data.add(String.format("\t\t - Order ID: %d", year.getValue().get(i).id));
                counter++;
            }
            counter++;
        }
        notifyDataSetChanged();
    }

    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ViewTypes.HEADER) {
            return new HeaderHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header, parent, false));
        } else {
            return new OrderHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(BaseHolder holder, int position) {
        if (holder instanceof HeaderHolder) {
            ((HeaderHolder) holder).headerView.setText(data.get(position));
        } else {
            ((OrderHolder) holder).orderView.setText(data.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (headerIndices.contains(position)) {
            return ViewTypes.HEADER;
        } else {
            return ViewTypes.ORDER;
        }
    }

    public static abstract class BaseHolder extends RecyclerView.ViewHolder {

        public BaseHolder(View itemView) {
            super(itemView);
        }
    }

    public static class HeaderHolder extends BaseHolder {
        private TextView headerView;

        public HeaderHolder(View itemView) {
            super(itemView);
            headerView = (TextView) itemView.findViewById(R.id.header_name);
        }
    }

    public static class OrderHolder extends BaseHolder {
        private TextView orderView;

        public OrderHolder(View itemView) {
            super(itemView);
            orderView = (TextView) itemView.findViewById(R.id.order_number);
        }
    }

    public static class ViewTypes {
        public static final int ORDER = 1;
        public static final int HEADER = 0;
    }
}
