package org.brianodisho.omdb;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by brianodisho on 8/18/16.
 */
public class OmdbAPIFactory {

    private OmdbAPIFactory() {}


    private static Retrofit retrofit() {
        return new Retrofit.Builder()
                .baseUrl("http://omdbapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    public static OmdbAPI getOmdbAPI() {
        Omdb omdb = retrofit().create(Omdb.class);
        return new OmdbAPI(omdb);
    }

}
