[![Download](https://api.bintray.com/packages/brianodisho/omdb/omdb/images/download.svg)](https://bintray.com/brianodisho/omdb/omdb/_latestVersion)

OMDb API
---------------

A Java library for the [Open Movie Database API](http://omdbapi.com/).  It simplifies the process of making HTTP requests against the API, request construction, and response parsing for Java/Android developers.

##Installation

Install using [Maven](https://maven.apache.org/):

```xml
<dependency>
  <groupId>org.brianodisho.omdb</groupId>
  <artifactId>omdb</artifactId>
  <version>1.1</version>
</dependency>
```
or

Install using [Gradle](http://gradle.org/):

```groovy
repositories {
    jcenter()
}

dependencies {
    ...
    compile 'org.brianodisho.omdb:omdb:1.1'
    ...
}
```



##Usage

This library uses an `OmdbAPI` object to query against the API. Instantiate an `OmdbAPI` object by using `OmdbAPIFactory`.

```java
OmdbAPI omdbAPI = OmdbAPIFactory.getOmdbAPI();
```




##Making Requests

A `Query` object must be passed to the `search()` or `getDetailedListing()` methods to make requests against the API.

```java
Query query = new Query.Builder(title)
                .imdbID(imdbID) // Optional
                .type(type) // Optional
                .year(year) // Optional
                .page(page) // Optional
                .build();

try {
	SearchResponse response = omdbAPI.search(query);
	DetailedListing movie = omdbAPI.getDetailedListing(query);
} catch (IOException | OmdbException e) {
	e.printStackTrace();
}
```
