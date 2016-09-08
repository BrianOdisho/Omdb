package org.brianodisho.omdb;

import org.brianodisho.omdb.model.DetailedListing;
import org.brianodisho.omdb.model.SearchResponse;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by brianodisho on 8/23/16.
 */
public class OmdbAPITest {

    private final static String title = "Fight Club";
    private final static String imdbID = "tt0137523";
    private OmdbAPI omdbAPI;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        omdbAPI = OmdbAPIFactory.getOmdbAPI();
    }

    @Test
    public void searchWithTitle() throws Exception {
        Query query = new Query.Builder(title).build();
        SearchResponse searchResponse = omdbAPI.search(query);

        assertTrue(Boolean.valueOf(searchResponse.getResponse()));
        assertTrue(Integer.valueOf(searchResponse.getTotalResults()) > 0);
    }

    @Test
    public void searchWithoutTitle() throws Exception {
        Query query = new Query.Builder(imdbID).build();
        exception.expect(OmdbException.class);
        exception.expectMessage("Query must contain title parameter for search.");
        omdbAPI.search(query);
    }

    @Test
    public void getDetailedListingWithTitle() throws Exception {
        Query query = new Query.Builder(title).build();
        DetailedListing movie = omdbAPI.getDetailedListing(query);

        assertEquals(title, movie.getTitle());
    }

    @Test
    public void getDetailedListingWithID() throws Exception {
        Query query = new Query.Builder(imdbID).build();
        DetailedListing movie = omdbAPI.getDetailedListing(query);

        assertEquals(imdbID, movie.getImdbID());
    }

}