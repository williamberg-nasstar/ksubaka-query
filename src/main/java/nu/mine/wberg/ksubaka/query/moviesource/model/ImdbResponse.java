package nu.mine.wberg.ksubaka.query.moviesource.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ImdbResponse {

    @JsonProperty("title_popular")
    private List<Title> titlePopulars;

    public List<Title> getTitlePopulars() {
        return titlePopulars;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Title {

        @JsonProperty("title")
        private String title;

        @JsonProperty("description")
        private String description;

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }
    }

}
