package org.brianodisho.omdb;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by brianodisho on 8/31/16.
 */
public class Query {

    private final Map<String, String> queryMap = new HashMap<>(6);


    private Query(Builder builder) {
        queryMap.put("t", builder.title);
        queryMap.put("i", builder.imdbID);
        queryMap.put("type", builder.type);
        queryMap.put("y", builder.year);
        queryMap.put("page", builder.page);
    }


    public Map<String, String> getQueryMap() {
        return queryMap;
    }



    public static class Builder {

        private String title = ""; // Required Param
        private String imdbID = ""; // Optional Param
        private String type = ""; // Optional Param
        private String year = ""; // Optional Param
        private String page = ""; // Optional Param

        public Builder(String query) {
            if (query.startsWith("tt")) {
                this.imdbID = query;
            } else {
                this.title = query;
            }
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder imdbID(String imdbID) {
            this.imdbID = imdbID;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder year(String year) {
            this.year = year;
            return this;
        }

        public Builder page(String page) {
            this.page = page;
            return this;
        }

        public Query build() {
            return new Query(this);
        }

    }

}
