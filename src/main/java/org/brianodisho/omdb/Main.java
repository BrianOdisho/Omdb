package org.brianodisho.omdb;

import org.brianodisho.omdb.model.Listing;
import org.brianodisho.omdb.model.DetailedListing;
import org.brianodisho.omdb.model.SearchResponse;

import java.io.IOException;
import java.util.List;

/**
 * Created by brianodisho on 8/18/16.
 */
public class Main {

    public static void main(String[] args) {

        Query query = new Query();
        query.put("t", "fight club");

        OmdbAPI omdb = OmdbFactory.getInstance().getOmdbAPI();


        try {
            DetailedListing movie = omdb.getDetailedListing(query);
            System.out.println(movie.getResponse());
            System.out.println(movie.getTitle());
            System.out.println(movie.getImdbID());
            System.out.println(movie.getGenre());
            System.out.println(movie.getActors());
            System.out.println(movie.getYear());
            System.out.println(movie.getPlot());

            System.out.println("-----------------------------------");
            query.put("s", "fight club");
            SearchResponse searchResponse = omdb.search(query);
            System.out.println(searchResponse.getResponse());
            System.out.println(searchResponse.getTotalResults());
            List<Listing> listings = searchResponse.getResults();

            for (Listing listing : listings) {
                System.out.println(listing.getTitle());
            }

        } catch (IOException | OmdbException e) {
            e.printStackTrace();
        }

    }

}
