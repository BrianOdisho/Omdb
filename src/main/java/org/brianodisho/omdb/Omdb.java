package org.brianodisho.omdb;

import org.brianodisho.omdb.model.DetailedListing;
import org.brianodisho.omdb.model.SearchResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

import java.util.Map;

/**
 * Created by brianodisho on 8/18/16.
 */
public interface Omdb {

    @GET("/")
    Call<SearchResponse> search(@QueryMap Map<String, String> queryMap);

    @GET("/")
    Call<DetailedListing> getDetailedListing(@QueryMap Map<String, String> queryMap);

}


