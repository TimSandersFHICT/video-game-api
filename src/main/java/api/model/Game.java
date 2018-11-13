package api.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;

@Table(name = "[Game]")
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "[ID]")
    private Long id;

    @Column(name = "[Title]")
    private String title;

    @Column(name = "[Summary]")
    private String summary;

    @Column(name = "[Price]")
    private Double price;

    @Column(name = "[Release_Date]")
    private Date releaseDate;

    @Column(name = "[Rating]")
    private int rating;

    @Column(name = "[Image_Link]")
    private String imageLink;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "[DeveloperID]")
    private Developer developer;

    @ManyToOne
    @JoinColumn(name = "[GenreID]")
    private Genre genre;

    public Game() {}

    public Game(String title, String summary, Double price, Date releaseDate, int rating, String imageLink, Developer developer, Genre genre) {
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

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
