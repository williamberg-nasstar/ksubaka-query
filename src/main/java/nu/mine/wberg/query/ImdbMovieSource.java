package nu.mine.wberg.query;

import java.util.ArrayList;
import java.util.List;

public class ImdbMovieSource implements MovieSource {

    public ImdbMovieSource() {
    }

    public List<MovieData> getMovieData(String movieName) {
        return new ArrayList<MovieData>();
    }

}
