OMDb API
---------------

A Java library for the Open Movie Database API.  It simplifies the process of making HTTP requests against the API, request construction, and response parsing for Java/Android developers.

##Installation

Install using [Gradle](http://gradle.org/):

```groovy
repositories {
    mavenCentral()
}

dependencies {
    ...
    compile 'org.brianodisho.omdb:omdb:1.0'
    ...
}
```



##Usage

This library uses an `OmdbAPI` object to query against the API. Instantiate an `OmdbAPI` object by using `OmdbAPIFactory`.
         
```java       
OmdbAPI omdbAPI = OmdbAPIFactory.getInstance().getOmdbAPI();
```




##Making Requests

A `Query` object must be passed to the `search()` or `getDetailedListing()` methods to make requests against the API.  A `Query` object wraps a `Map<String, String>` object and accepts new <key, value> pairs similarly to a map.

```java
Query searchQuery = new Query();
searchQuery.put("s", "finding nemo");
searchQuery.put("type", "movie");

try {
	SearchResponse response = omdbAPI.search(searchQuery);
} catch (IOException | OmdbException e) {
	e.printStackTrace();
}
```

```java
Query query = new Query();

query.put("t", "fight club"); // title
query.put("y", "1999"); // year
query.put("type", "movie"); // type

try {
	DetailedListing movie = omdbAPI.getDetailedListing(query);
} catch (IOException | OmdbException e) {
	e.printStackTrace();
}
```
####Query Parameters

Valid Options for `search()`

| Parameter | Required | Valid Options | Default Value |	Description |
| --- | --- | --- | --- | --- |
| s | Yes | <empty> | <empty> | Movie title to search for. |
|type | No | movie, series, episode	| <empty> | Type of result to return. |
| y | No | <empty> | <empty> | Year of release. |

Valid Options for `getDetailedListing()`

| Parameter | Required | Valid Options | Default Value |	Description |
| --- | --- | --- | --- | --- |
| i	| Optional*	| <empty> | <empty> | A valid IMDb ID (e.g. tt1285016) |
| t | Optional* | <empty> | <empty> | Movie title to search for. |
|type | No | movie, series, episode	| <empty> | Type of result to return. |
| y | No | <empty> | <empty> | Year of release. |
| plot | No | short, full |	short | Return short or full plot. |

> **Note:** While both "i" and "t" are optional at least one argument is required.
