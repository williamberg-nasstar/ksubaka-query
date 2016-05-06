package nu.mine.wberg.ksubaka.query.moviesource.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OmdbTitleResponse {

    @JsonProperty("Director")
    private String director;

    public String getDirector() {
        return director;
    }

}
