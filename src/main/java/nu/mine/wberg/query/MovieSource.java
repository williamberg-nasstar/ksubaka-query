package nu.mine.wberg.query;

import java.util.List;

public interface MovieSource {

    List<MovieData> getMovieData(String movieName);

}
