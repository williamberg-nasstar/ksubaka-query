package nu.mine.wberg.query;

import java.util.ArrayList;
import java.util.List;

public class ImdbMovieSource implements MovieSource {

    public ImdbMovieSource() {
    }

    public List<MovieData> getMovieData(String movieName) {
        if (null == movieName || movieName.isEmpty()) {
            throw new IllegalArgumentException("No movie name was specified");
        }

        return new ArrayList<MovieData>();
    }

}
