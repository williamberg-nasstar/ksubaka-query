package nu.mine.wberg.query.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OmdbTitleResponse {

    @JsonProperty("Director")
    private String director;

    public String getDirector() {
        return director;
    }

}
