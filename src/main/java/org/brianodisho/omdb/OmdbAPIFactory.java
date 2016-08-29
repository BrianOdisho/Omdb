package org.brianodisho.omdb;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by brianodisho on 8/18/16.
 */
public class OmdbAPIFactory {

    private static final String BASE_URL = "http://omdbapi.com";
    private static OmdbAPIFactory instance = new OmdbAPIFactory();
    private OmdbAPI omdbAPI;

    private OmdbAPIFactory() {
        Retrofit retrofit = createAdapter().build();
        Omdb omdb = retrofit.create(Omdb.class);
        omdbAPI = new OmdbAPI(omdb);
    }

    public static OmdbAPIFactory getInstance() {
        return instance;
    }

    public OmdbAPI getOmdbAPI() {
        return omdbAPI;
    }

    private Retrofit.Builder createAdapter() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());
    }

}
