package be.thomasmore.party2.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Client {
    @Id
    private int id;
    private String name;
    private Date birthdate;
    private String gender;
    private Date startdate;

    public Client(String name, Date birthdate, String genderM, Date startdate) {
        this.name = name;
        this.birthdate = birthdate;
        this.gender = genderM;
        this.startdate = startdate;
    }

    public Client() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String genderM) {
        this.gender = genderM;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startDate) {
        this.startdate = startDate;
    }
}
