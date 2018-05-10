package manju.shopify_mobile_application.parsers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Manju on 2017-09-11.
 */

public class LineItem implements Serializable {
    @SerializedName("id")
    @Expose
    public long id;
    @SerializedName("variant_id")
    @Expose
    public long variantId;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("quantity")
    @Expose
    public long quantity;
    @SerializedName("price")
    @Expose
    public String price;
    @SerializedName("grams")
    @Expose
    public long grams;
    @SerializedName("sku")
    @Expose
    public String sku;
    @SerializedName("variant_title")
    @Expose
    public String variantTitle;
    @SerializedName("vendor")
    @Expose
    public String vendor;
    @SerializedName("fulfillment_service")
    @Expose
    public String fulfillmentService;
    @SerializedName("product_id")
    @Expose
    public long productId;
    @SerializedName("requires_shipping")
    @Expose
    public boolean requiresShipping;
    @SerializedName("taxable")
    @Expose
    public boolean taxable;
    @SerializedName("gift_card")
    @Expose
    public boolean giftCard;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("variant_inventory_management")
    @Expose
    public Object variantInventoryManagement;
    @SerializedName("properties")
    @Expose
    public List<Object> properties = null;
    @SerializedName("product_exists")
    @Expose
    public boolean productExists;
    @SerializedName("fulfillable_quantity")
    @Expose
    public long fulfillableQuantity;
    @SerializedName("total_discount")
    @Expose
    public String totalDiscount;
    @SerializedName("fulfillment_status")
    @Expose
    public Object fulfillmentStatus;
    @SerializedName("tax_lines")
    @Expose
    public List<Object> taxLines = null;
}
