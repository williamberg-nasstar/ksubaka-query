package nu.mine.wberg.ksubaka.query.moviesource;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MovieSourceFactoryTest {

    private MovieSourceFactory movieSourceFactory;

    @Before
    public void setUp() {
        movieSourceFactory = new MovieSourceFactory();
    }

    @Test
    public void imdbId_returnsImdbMovieSource() {
        MovieSource movieSource = movieSourceFactory.getMovieSource("imdb");
        if (!(movieSource instanceof ImdbMovieSource)) {
            fail();
        }
    }

    @Test
    public void omdbId_returnsOmdbMovieSource() {
        MovieSource movieSource = movieSourceFactory.getMovieSource("omdb");
        if (!(movieSource instanceof OmdbMovieSource)) {
            fail();
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void unknownId_throws() {
        MovieSource movieSource = movieSourceFactory.getMovieSource("not_a_real_movie_source_id");
    }

}
