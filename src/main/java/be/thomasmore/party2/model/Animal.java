package be.thomasmore.party2.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Animal {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "animal_generator")
    @SequenceGenerator(name = "animal_generator", sequenceName = "animal_seq", allocationSize = 1)
    @Id
    private Integer id;
    private String name;
    private String city;
    private String bio;
    @ManyToMany(mappedBy = "animals", fetch = FetchType.LAZY)
    private Collection<Party> parties;
    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    public Animal() {
    }

    public Animal(String name, String city, String bio, User user) {
        this.name = name;
        this.city = city;
        this.bio = bio;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Collection<Party> getParties() {
        return parties;
    }

    public void setParties(Collection<Party> parties) {
        this.parties = parties;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
