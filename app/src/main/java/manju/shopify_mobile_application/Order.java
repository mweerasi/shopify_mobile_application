package manju.shopify_mobile_application;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Manju on 2017-09-11.
 */

public class Order {
    @SerializedName("id")
    @Expose
    public long id;
    @SerializedName("email")
    @Expose
    public String email;
    @SerializedName("closed_at")
    @Expose
    public Object closedAt;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("updated_at")
    @Expose
    public String updatedAt;
    @SerializedName("number")
    @Expose
    public long number;
    @SerializedName("note")
    @Expose
    public Object note;
    @SerializedName("token")
    @Expose
    public String token;
    @SerializedName("gateway")
    @Expose
    public String gateway;
    @SerializedName("test")
    @Expose
    public boolean test;
    @SerializedName("total_price")
    @Expose
    public String totalPrice;
    @SerializedName("subtotal_price")
    @Expose
    public String subtotalPrice;
    @SerializedName("total_weight")
    @Expose
    public long totalWeight;
    @SerializedName("total_tax")
    @Expose
    public String totalTax;
    @SerializedName("taxes_included")
    @Expose
    public boolean taxesIncluded;
    @SerializedName("currency")
    @Expose
    public String currency;
    @SerializedName("financial_status")
    @Expose
    public String financialStatus;
    @SerializedName("confirmed")
    @Expose
    public boolean confirmed;
    @SerializedName("total_discounts")
    @Expose
    public String totalDiscounts;
    @SerializedName("total_line_items_price")
    @Expose
    public String totalLineItemsPrice;
    @SerializedName("cart_token")
    @Expose
    public Object cartToken;
    @SerializedName("buyer_accepts_marketing")
    @Expose
    public boolean buyerAcceptsMarketing;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("referring_site")
    @Expose
    public Object referringSite;
    @SerializedName("landing_site")
    @Expose
    public Object landingSite;
    @SerializedName("cancelled_at")
    @Expose
    public Object cancelledAt;
    @SerializedName("cancel_reason")
    @Expose
    public Object cancelReason;
    @SerializedName("total_price_usd")
    @Expose
    public String totalPriceUsd;
    @SerializedName("checkout_token")
    @Expose
    public Object checkoutToken;
    @SerializedName("reference")
    @Expose
    public Object reference;
    @SerializedName("user_id")
    @Expose
    public long userId;
    @SerializedName("location_id")
    @Expose
    public Object locationId;
    @SerializedName("source_identifier")
    @Expose
    public Object sourceIdentifier;
    @SerializedName("source_url")
    @Expose
    public Object sourceUrl;
    @SerializedName("processed_at")
    @Expose
    public String processedAt;
    @SerializedName("device_id")
    @Expose
    public Object deviceId;
    @SerializedName("phone")
    @Expose
    public Object phone;
    @SerializedName("customer_locale")
    @Expose
    public Object customerLocale;
    @SerializedName("app_id")
    @Expose
    public long appId;
    @SerializedName("browser_ip")
    @Expose
    public Object browserIp;
    @SerializedName("landing_site_ref")
    @Expose
    public Object landingSiteRef;
    @SerializedName("order_number")
    @Expose
    public long orderNumber;
    @SerializedName("discount_codes")
    @Expose
    public List<Object> discountCodes = null;
    @SerializedName("note_attributes")
    @Expose
    public List<Object> noteAttributes = null;
    @SerializedName("payment_gateway_names")
    @Expose
    public List<String> paymentGatewayNames = null;
    @SerializedName("processing_method")
    @Expose
    public String processingMethod;
    @SerializedName("checkout_id")
    @Expose
    public Object checkoutId;
    @SerializedName("source_name")
    @Expose
    public String sourceName;
    @SerializedName("fulfillment_status")
    @Expose
    public Object fulfillmentStatus;
    @SerializedName("tax_lines")
    @Expose
    public List<Object> taxLines = null;
    @SerializedName("tags")
    @Expose
    public String tags;
    @SerializedName("contact_email")
    @Expose
    public String contactEmail;
    @SerializedName("order_status_url")
    @Expose
    public Object orderStatusUrl;
    @SerializedName("line_items")
    @Expose
    public List<LineItem> lineItems = null;
    @SerializedName("shipping_lines")
    @Expose
    public List<Object> shippingLines = null;
    @SerializedName("billing_address")
    @Expose
    public BillingAddress billingAddress;
    @SerializedName("shipping_address")
    @Expose
    public ShippingAddress shippingAddress;
    @SerializedName("fulfillments")
    @Expose
    public List<Object> fulfillments = null;
    @SerializedName("refunds")
    @Expose
    public List<Object> refunds = null;
    @SerializedName("customer")
    @Expose
    public Customer customer;

    public String getEmail() {
        return email;
    }


}
