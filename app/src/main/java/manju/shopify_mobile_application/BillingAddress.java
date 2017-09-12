package manju.shopify_mobile_application;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Manju on 2017-09-11.
 */

class BillingAddress {
    @SerializedName("first_name")
    @Expose
    public String firstName;
    @SerializedName("address1")
    @Expose
    public String address1;
    @SerializedName("phone")
    @Expose
    public String phone;
    @SerializedName("city")
    @Expose
    public String city;
    @SerializedName("zip")
    @Expose
    public String zip;
    @SerializedName("province")
    @Expose
    public String province;
    @SerializedName("country")
    @Expose
    public String country;
    @SerializedName("last_name")
    @Expose
    public String lastName;
    @SerializedName("address2")
    @Expose
    public Object address2;
    @SerializedName("company")
    @Expose
    public Object company;
    @SerializedName("latitude")
    @Expose
    public double latitude;
    @SerializedName("longitude")
    @Expose
    public double longitude;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("country_code")
    @Expose
    public String countryCode;
    @SerializedName("province_code")
    @Expose
    public String provinceCode;
}
