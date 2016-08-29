package org.brianodisho.omdb;

import org.brianodisho.omdb.model.DetailedListing;
import org.brianodisho.omdb.model.SearchResponse;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by brianodisho on 8/23/16.
 */
public class SearchTest {

    private final String title = "Fight Club";
    private final String imdbID = "tt0137523";

    @Test
    public void search() throws Exception {
        OmdbAPI omdbAPI = OmdbAPIFactory.getInstance().getOmdbAPI();
        Query query = new Query();
        query.put("s", title);
        SearchResponse searchResponse = omdbAPI.search(query);

        assertTrue(Boolean.valueOf(searchResponse.getResponse()));
        assertFalse(searchResponse.getResults().isEmpty());
    }

    @Test
    public void getDetailedListingByTitle() throws Exception {
        OmdbAPI omdbAPI = OmdbAPIFactory.getInstance().getOmdbAPI();
        Query query = new Query();
        query.put("t", title);
        DetailedListing movie = omdbAPI.getDetailedListing(query);

        assertEquals(title, movie.getTitle());
    }

    @Test
    public void getDetailedListingByID() throws Exception {
        OmdbAPI omdbAPI = OmdbAPIFactory.getInstance().getOmdbAPI();
        Query query = new Query();
        query.put("i", imdbID);
        DetailedListing movie = omdbAPI.getDetailedListing(query);

        assertEquals(imdbID, movie.getImdbID());
    }

    @Test(expected = OmdbException.class)
    public void getDetailedListingException() throws Exception {
        OmdbAPI omdbAPI = OmdbAPIFactory.getInstance().getOmdbAPI();
        Query query = new Query();
        DetailedListing movie = omdbAPI.getDetailedListing(query);
    }



}