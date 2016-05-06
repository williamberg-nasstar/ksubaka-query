package nu.mine.wberg.query;

public class MovieData {

    private String name;
    private String director;
    private String year;

    // could use a builder here but there are only 3 fields
    public MovieData(String name, String director, String year) {
        this.name = name;
        this.director = director;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
