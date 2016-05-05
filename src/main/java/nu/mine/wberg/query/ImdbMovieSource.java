package nu.mine.wberg.query;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import nu.mine.wberg.query.model.ImdbResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The 'description' field contains the year and director. The format varies,
 * but generally obeys these rules:
 *   - first four characters indicate release year
 *   - contains an <a> tag which contains the director's name
 */
public class ImdbMovieSource implements MovieSource {

    private static final Pattern DIRECTOR_NAME = Pattern.compile("<a href='.*'>(.*)</a>");
    private static final String QUERY = "http://www.imdb.com/xml/find?json=1&nr=1&tt=on&q={movie}";

    public List<MovieData> getMovieData(String movieName) {
        if (null == movieName || movieName.isEmpty()) {
            throw new IllegalArgumentException("No movie name was specified");
        }

        HttpResponse<ImdbResponse> imdbResponse = null;
        try {
            imdbResponse = Unirest.get(QUERY)
                    .routeParam("movie", movieName)
                    .asObject(ImdbResponse.class);
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
        ImdbResponse responseBody = imdbResponse.getBody();

        List<MovieData> result = new ArrayList<MovieData>();
        for (ImdbResponse.Title title : responseBody.getTitlePopulars()) {
            if (!isMovie(title)) {
                continue;
            }

            // TODO what if parseInt throws?
            int year = Integer.parseInt(title.getDescription().substring(0, 4));
            String director;
            Matcher directorMatcher = DIRECTOR_NAME.matcher(title.getDescription());
            if (directorMatcher.find()) {
                director = directorMatcher.group(1);
            }
            else {
                director = "Unknown";
            }

            result.add(new MovieData(title.getTitle(),
                    director,
                    year));
        }
        return result;
    }

    private boolean isMovie(ImdbResponse.Title title) {
        return !title.getDescription().contains("TV series");
    }

}
