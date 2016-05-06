package nu.mine.wberg.ksubaka.query.moviesource;

public class MovieSourceFactory {

    private static final String IMDB_ID = "imdb";
    private static final String OMDB_ID = "omdb";

    public MovieSource getMovieSource(String id) {
        if (IMDB_ID.equals(id)) {
            return new ImdbMovieSource();
        }
        else if (OMDB_ID.equals(id)) {
            return new OmdbMovieSource();
        }
        else {
            throw new IllegalArgumentException("Unknown movie source id " + id);
        }
    }

}
