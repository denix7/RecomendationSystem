package Recomendation;

public class Movie {

    private String id;
    private String title;
    private int year;
    private String country;
    private String genres;
    private String director;
    private int minutes;
    private String poster;

    public Movie(String id, String title, String year, String genres, String director, String country, String minutes, String poster) {
        this.id = id;
        this.title = title;
        this.year = Integer.parseInt(year);
        this.genres = genres;
        this.director = director;
        this.country = country;
        this.minutes = Integer.parseInt(minutes);
        this.poster = poster;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getGenres() {
        return genres;
    }

    public String getDirector() {
        return director;
    }

    public String getCountry() {
        return country;
    }

    public int getMinutes() {
        return minutes;
    }

    public String getPoster() {
        return poster;
    }

    public String toString()
    {
        return "[" + id + " "  + title + " " + year + " " + country  + " " + genres + " " + director + " " + minutes + " " + poster + "]";
    }
}
