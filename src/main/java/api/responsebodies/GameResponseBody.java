package api.responsebodies;

import api.model.Developer;
import api.model.Genre;
import java.sql.Date;


public class GameResponseBody {

    private Long id;
    private String title;
    private String summary;
    private Double price;
    private Date releaseDate;
    private int rating;
    private String imageLink;
    private Developer developer;
    private Genre genre;

    public GameResponseBody(Long id, String title, String summary, Double price, Date releaseDate, int rating, String imageLink, Developer developer, Genre genre) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.price = price;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.imageLink = imageLink;
        this.developer = developer;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public Double getPrice() {
        return price;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public int getRating() {
        return rating;
    }

    public String getImageLink() {
        return imageLink;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
