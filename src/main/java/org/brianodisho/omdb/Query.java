package org.brianodisho.omdb;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by brianodisho on 8/22/16.
 */
public class Query {

    private final Map<String, String> queryMap = new HashMap<>(5);

    public boolean containsKey(Object key) {
        return queryMap.containsKey(key);
    }

    public String get(Object key) {
        return queryMap.get(key);
    }

    public String put(String key, String value) {
        switch (key) {
            case "i":
            case "s":
            case "t":
            case "y":
                queryMap.put(key, value);
                return value;
            case "type":
                if (value.equals("movie") || value.equals("series") || value.equals("episode")) {
                    queryMap.put(key, value);
                    return value;
                } else {
                    return null;
                }
            case "plot":
                if (value.equals("short") || value.equals("long")) {
                    queryMap.put(key, value);
                    return value;
                } else {
                    return null;
                }
            default:
                return null;
        }
    }

    public Map<String, String> getQueryMap() {
        return queryMap;
    }

}
