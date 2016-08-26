package org.brianodisho.omdb;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by brianodisho on 8/22/16.
 */
public class QueryTest {

    private final String title = "Fight Club";
    private final String imdbID = "tt0137523";
    private final String year = "1999";
    private final String type = "movie";
    private final String plot = "short";

    @Test
    public void put() throws Exception {
        Query query = new Query();

        assertEquals(title, query.put("t", title));
        assertEquals(imdbID, query.put("i", imdbID));
        assertEquals(year, query.put("y", year));
        assertEquals(type, query.put("type", type));
        assertEquals(plot, query.put("plot", plot));
        assertNull(query.put("UNDEFINED_KEY", title));
        assertNull(query.put("type", "invalidValue"));
        assertNull(query.put("plot", "invalidValue"));
    }

    @Test
    public void get() throws Exception {
        Query query = new Query();

        assertEquals(query.put("t", title), query.get("t"));
        assertEquals(query.put("i", imdbID), query.get("i"));
        assertEquals(query.put("y", year), query.get("y"));
        assertEquals(query.put("type", type), query.get("type"));
        assertEquals(query.put("plot", plot), query.get("plot"));
        assertNull(query.get("UNDEFINED_KEY"));
    }

    @Test
    public void getQueryMap() throws Exception {
        Query query = new Query();
        query.put("t", title);
        query.put("i", imdbID);
        query.put("y", year);
        query.put("type", type);
        query.put("plot", plot);

        assertTrue(query.getQueryMap().containsKey("t"));
        assertTrue(query.getQueryMap().containsKey("i"));
        assertTrue(query.getQueryMap().containsKey("y"));
        assertTrue(query.getQueryMap().containsKey("type"));
        assertTrue(query.getQueryMap().containsKey("plot"));
    }

}