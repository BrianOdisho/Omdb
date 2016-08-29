OMDB API
---------------

A Java library for the Open Movie Database API.  It simplifies the process of making HTTP requests against the API, request construction, and response parsing for Java/Android developers.

**Installation:**

Install using [Gradle](http://gradle.org/):

```groovy
repositories {
    mavenCentral()
}

dependencies {
    ...
    compile 'xxxxxxxxxx'
    ...
}
```
Usage
-------------------

This library uses an `OmdbAPI` object to query against the API. Instantiate an `OmdbAPI` object by using `OmdbAPIFactory`.
         
```java       
OmdbAPI omdbAPI = OmdbAPIFactory.getInstance().getOmdbAPI();
```


A `Query` object must be passed as a `Map<String, String>` to the `search()` or `getDetailedListing()` methods to make requests against the API.  `Query` objects can be passed as a `Map<String, String>` by calling `getQueryMap()`.
