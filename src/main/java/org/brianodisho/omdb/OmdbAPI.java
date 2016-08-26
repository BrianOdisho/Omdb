package org.brianodisho.omdb;

import org.brianodisho.omdb.model.DetailedListing;
import org.brianodisho.omdb.model.SearchResponse;

import java.io.IOException;

/**
 * Created by brianodisho on 8/21/16.
 */
public class OmdbAPI {

    private Omdb omdb;

    private OmdbAPI() {}

    public OmdbAPI(Omdb omdb) {
        this.omdb = omdb;
    }

    public SearchResponse search(Query query) throws IOException, OmdbException {
        if (query.containsKey("s")) {
            return omdb.search(query.getQueryMap()).execute().body();
        } else {
            throw new OmdbException("Query must contain a mapping for the \"s\" key to be a valid query in a search");
        }
    }

    public DetailedListing getDetailedListing(Query query) throws IOException, OmdbException {
        if (query.containsKey("i") || query.containsKey("t")) {
            return omdb.getDetailedListing(query.getQueryMap()).execute().body();
        } else {
            throw new OmdbException(
                    "Query must contain a mapping for at least the \"i\" or \"t\" key to be a valid query" +
                    "for getting a detailed listing.");
        }
    }

}
