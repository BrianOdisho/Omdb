package org.brianodisho.omdb.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by brianodisho on 8/19/16.
 */
public class SearchResponse {

    @SerializedName("Search")
    private List<Listing> results;

    @SerializedName("totalResults")
    private String totalResults;

    @SerializedName("Response")
    private String response;

    @SerializedName("Error")
    private String error;

    public List<Listing> getResults() {
        return results;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public String getResponse() {
        return response;
    }

    public String getError() {
        return error;
    }

}