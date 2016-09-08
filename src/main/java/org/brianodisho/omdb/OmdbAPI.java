package org.brianodisho.omdb;

import org.brianodisho.omdb.model.DetailedListing;
import org.brianodisho.omdb.model.SearchResponse;

import java.io.IOException;

/**
 * Created by brianodisho on 8/21/16.
 */
public class OmdbAPI {

    private Omdb omdb;


    public OmdbAPI(Omdb omdb) {
        this.omdb = omdb;
    }


    public SearchResponse search(Query query) throws IOException, OmdbException {
        if (query.getQueryMap().get("t").isEmpty()) {
            throw new OmdbException("Query must contain title parameter for search.");
        } else {
            query.getQueryMap().put("s", query.getQueryMap().get("t"));
            return omdb.search(query.getQueryMap()).execute().body();
        }
    }


    public DetailedListing getDetailedListing(Query query) throws IOException {
        if (query.getQueryMap().containsKey("s")) {
            query.getQueryMap().replace("s", "");
        }
        return omdb.getDetailedListing(query.getQueryMap()).execute().body();
    }

}
