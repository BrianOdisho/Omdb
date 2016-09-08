package org.brianodisho.omdb;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by brianodisho on 8/31/16.
 */
public class QueryTest {

    private final String title = "Fight Club";
    private final String imdbID = "tt0137523";
    private final String type = "movie";
    private final String year = "1999";
    private final String page = "1";

    @Test
    public void QueryTitleTest() throws Exception {
        Query query = new Query.Builder(title).build();
        Map<String, String> queryMap = query.getQueryMap();

        assertEquals(title, queryMap.get("t"));
        assertEquals("", queryMap.get("i"));
        assertEquals("", queryMap.get("type"));
        assertEquals("", queryMap.get("y"));
        assertEquals("", queryMap.get("page"));
    }

    @Test
    public void QueryIDTest() throws Exception {
        Query query = new Query.Builder(imdbID).build();
        Map<String, String> queryMap = query.getQueryMap();

        assertEquals("", queryMap.get("t"));
        assertEquals(imdbID, queryMap.get("i"));
        assertEquals("", queryMap.get("type"));
        assertEquals("", queryMap.get("y"));
        assertEquals("", queryMap.get("page"));
    }

    @Test
    public void QueryAllTest() throws Exception {
        Query query = new Query.Builder(title)
                .title(title)
                .imdbID(imdbID)
                .type(type)
                .year(year)
                .page(page)
                .build();

        Map<String, String> queryMap = query.getQueryMap();

        assertEquals(title, queryMap.get("t"));
        assertEquals(imdbID, queryMap.get("i"));
        assertEquals(type, queryMap.get("type"));
        assertEquals(year, queryMap.get("y"));
        assertEquals(page, queryMap.get("page"));
    }
}