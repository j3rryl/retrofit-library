package com.example.retrofitlibrary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserData {
    @SerializedName("total_count")
    @Expose
    private String total_count;
    @SerializedName("incomplete_results")
    @Expose
    private String incomplete_results;
    @SerializedName("items")
    @Expose
    private List<UserArray> userArray = null;

    public String getTotal_count() {
        return total_count;
    }

    public void setTotal_count(String total_count) {
        this.total_count = total_count;
    }

    public String getIncomplete_results() {
        return incomplete_results;
    }

    public void setIncomplete_results(String incomplete_results) {
        this.incomplete_results = incomplete_results;
    }

    public List<UserArray> getUserArray() {
        return userArray;
    }

    public void setUserArray(List<UserArray> userArray) {
        this.userArray = userArray;
    }
}
