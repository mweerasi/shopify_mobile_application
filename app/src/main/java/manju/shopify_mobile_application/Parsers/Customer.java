package manju.shopify_mobile_application.Parsers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Manju on 2017-09-11.
 */

public class Customer implements Serializable {
    @SerializedName("id")
    @Expose
    public long id;
    @SerializedName("email")
    @Expose
    public String email;
    @SerializedName("accepts_marketing")
    @Expose
    public boolean acceptsMarketing;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("updated_at")
    @Expose
    public String updatedAt;
    @SerializedName("first_name")
    @Expose
    public String firstName;
    @SerializedName("last_name")
    @Expose
    public String lastName;
    @SerializedName("orders_count")
    @Expose
    public long ordersCount;
    @SerializedName("state")
    @Expose
    public String state;
    @SerializedName("total_spent")
    @Expose
    public String totalSpent;
    @SerializedName("last_order_id")
    @Expose
    public long lastOrderId;
    @SerializedName("note")
    @Expose
    public Object note;
    @SerializedName("verified_email")
    @Expose
    public boolean verifiedEmail;
    @SerializedName("multipass_identifier")
    @Expose
    public Object multipassIdentifier;
    @SerializedName("tax_exempt")
    @Expose
    public boolean taxExempt;
    @SerializedName("phone")
    @Expose
    public Object phone;
    @SerializedName("tags")
    @Expose
    public String tags;
    @SerializedName("last_order_name")
    @Expose
    public String lastOrderName;
    @SerializedName("default_address")
    @Expose
    public DefaultAddress defaultAddress;

    public String getTotalSpent() {
        return totalSpent;
    }

    public long getId() {
        return id;
    }
}
