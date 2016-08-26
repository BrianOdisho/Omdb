package org.brianodisho.omdb;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by brianodisho on 8/22/16.
 */
public class Query implements Map<String, String> {

    private final Map<String, String> queryMap = new HashMap<>(5);

    @Override
    public int size() {
        return queryMap.size();
    }

    @Override
    public boolean isEmpty() {
        return queryMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return queryMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return queryMap.containsValue(value);
    }

    @Override
    public String get(Object key) {
        return queryMap.get(key);
    }

    @Override
    public String remove(Object key) {
        return queryMap.remove(key);
    }

    @Override
    public void putAll(Map<? extends String, ? extends String> m) {
        queryMap.putAll(m);
    }

    @Override
    public void clear() {
        queryMap.clear();
    }

    @Override
    public Set<String> keySet() {
        return queryMap.keySet();
    }

    @Override
    public Collection<String> values() {
        return queryMap.values();
    }

    @Override
    public Set<Entry<String, String>> entrySet() {
        return queryMap.entrySet();
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
