package api.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;

@Table(name = "[VideoGame]")
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class VideoGame {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "[ID]")
    private Long id;

    @Column(name = "[Publisher]")
    private String publisher;

    @Column(name = "[Title]")
    private String title;

    public VideoGame() {}

    public VideoGame(String title, String publisher)
    {
        this.title = title;
        this.publisher = publisher;
    }

}
