package manju.shopify_mobile_application.parsers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Manju on 2017-09-11.
 */

public class DefaultAddress implements Serializable {
    @SerializedName("id")
    @Expose
    public long id;
    @SerializedName("customer_id")
    @Expose
    public long customerId;
    @SerializedName("first_name")
    @Expose
    public String firstName;
    @SerializedName("last_name")
    @Expose
    public String lastName;
    @SerializedName("company")
    @Expose
    public Object company;
    @SerializedName("address1")
    @Expose
    public String address1;
    @SerializedName("address2")
    @Expose
    public Object address2;
    @SerializedName("city")
    @Expose
    public String city;
    @SerializedName("province")
    @Expose
    public String province;
    @SerializedName("country")
    @Expose
    public String country;
    @SerializedName("zip")
    @Expose
    public String zip;
    @SerializedName("phone")
    @Expose
    public String phone;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("province_code")
    @Expose
    public String provinceCode;
    @SerializedName("country_code")
    @Expose
    public String countryCode;
    @SerializedName("country_name")
    @Expose
    public String countryName;
    @SerializedName("default")
    @Expose
    public boolean _default;
}
