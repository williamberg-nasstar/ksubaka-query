package nu.mine.wberg.query;

public class MovieSourceFactory {

    private static final String IMDB_ID = "imdb";

    public MovieSource getMovieSource(String id) {
        if (IMDB_ID.equals(id)) {
            return new ImdbMovieSource();
        }
        else {
            throw new IllegalArgumentException("Unknown movie source id " + id);
        }
    }

}
