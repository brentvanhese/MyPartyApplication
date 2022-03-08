package be.thomasmore.party2.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Party {
    @Id
    private int id;
    private String name;
    private Integer pricePresaleInEur;
    private Integer princeInEur;
    private String extraInfo;
    @Temporal(TemporalType.DATE)
    private Date date;
    @Temporal(TemporalType.TIME)
    private Date doors;
    @ManyToOne
    private Venue venue;

    public Party() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPricePresaleInEur() {
        return pricePresaleInEur;
    }

    public void setPricePresaleInEur(Integer pricePresaleInEur) {
        this.pricePresaleInEur = pricePresaleInEur;
    }

    public Integer getPrinceInEur() {
        return princeInEur;
    }

    public void setPrinceInEur(Integer princeInEur) {
        this.princeInEur = princeInEur;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDoors() {
        return doors;
    }

    public void setDoors(Date doors) {
        this.doors = doors;
    }
}
