package nu.mine.wberg.query.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OmdbSearchResponse {

    @JsonProperty("Search")
    private List<SearchResult> searchResults;

    public List<SearchResult> getSearchResults() {
        return searchResults;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SearchResult {

        @JsonProperty("Title")
        private String title;

        @JsonProperty("Year")
        private String year;

        @JsonProperty("Type")
        private String type;

        public String getTitle() {
            return title;
        }

        public String getYear() {
            return year;
        }

        public String getType() {
            return type;
        }

    }

}
