package nu.mine.wberg.ksubaka.query.moviesource;

import java.util.List;

public interface MovieSource {

    List<MovieData> getMovieData(String movieName);

}
