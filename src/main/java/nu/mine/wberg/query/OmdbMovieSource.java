package nu.mine.wberg.query;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import nu.mine.wberg.query.model.OmdbSearchResponse;
import nu.mine.wberg.query.model.OmdbTitleResponse;

import java.util.ArrayList;
import java.util.List;

public class OmdbMovieSource implements MovieSource {

    private static final String SEARCH_QUERY = "http://omdbapi.com/?s={movie}&r=json";
    private static final String TITLE_QUERY = "http://omdbapi.com/?t={movie}&r=json";

    public List<MovieData> getMovieData(String movieName) {
        if (null == movieName || movieName.isEmpty()) {
            throw new IllegalArgumentException("No movie name was specified");
        }

        HttpResponse<OmdbSearchResponse> omdbSearchResponse;
        try {
            omdbSearchResponse = Unirest.get(SEARCH_QUERY)
                    .routeParam("movie", movieName)
                    .asObject(OmdbSearchResponse.class);
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
        OmdbSearchResponse searchResponseBody = omdbSearchResponse.getBody();

        List<MovieData> result = new ArrayList<MovieData>();
        for (OmdbSearchResponse.SearchResult searchResult : searchResponseBody.getSearchResults()) {
            if (!isMovie(searchResult)) {
                continue;
            }

            String title = searchResult.getTitle();
            String year = searchResult.getYear();
            HttpResponse<OmdbTitleResponse> omdbTitleResponse;
            try {
                omdbTitleResponse = Unirest.get(TITLE_QUERY)
                        .routeParam("movie", searchResult.getTitle())
                        .asObject(OmdbTitleResponse.class);
            } catch (UnirestException e) {
                throw new RuntimeException(e);
            }
            OmdbTitleResponse titleResponseBody = omdbTitleResponse.getBody();
            String director = titleResponseBody.getDirector();

            result.add(new MovieData(title, director, year));
        }
        return result;
    }

    private boolean isMovie(OmdbSearchResponse.SearchResult searchResult) {
        return "movie".equals(searchResult.getType());
    }

}
