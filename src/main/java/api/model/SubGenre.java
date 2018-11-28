package api.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Table(name = "[SubGenre]")
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class SubGenre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "[ID]")
    private Long id;

    @Column(name = "[Name]")
    private String name;

    @ManyToOne
    @JoinColumn(name = "[GenreID]")
    private Genre genre;

    public SubGenre() {}

    public SubGenre(String name, Genre genre) {
        this.name = name;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
