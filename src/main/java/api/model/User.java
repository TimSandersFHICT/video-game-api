package api.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table(name = "[User]")
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "[ID]")
    private Long id;

    @Column(name = "[Name]")
    private String name;

    @Column(name = "[Email]")
    private String email;

    @Column(name = "[Password]")
    private String password;

    @Column(name = "[Token]")
    private String token;

    @Column(name = "[Created]")
    private Date createdAt;

    @Column(name = "[SignedIn]")
    private Date signIn;



    public User() {
    }

    public User(String name, String email, String password, String token, Date createdAt, Date signIn) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.token = token;
        this.createdAt = createdAt;
        this.signIn = signIn;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getSignIn() {
        return signIn;
    }

    public void setSignIn(Date signIn) {
        this.signIn = signIn;
    }

}