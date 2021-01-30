package wel.medicalapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BodyFat {

    @Id
    @GeneratedValue
    private Long id;
    private String gender;

    private String height;

    private String waist;
    private String neck;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWaist() {
        return waist;
    }

    public void setWaist(String waist) {
        this.waist = waist;
    }

    public String getNeck() {
        return neck;
    }

    public void setNeck(String neck) {
        this.neck = neck;
    }

    public BodyFat() {
    }

    public BodyFat(String gender, String height, String waist, String neck) {
        this.gender = gender;
        this.height = height;
        this.waist = waist;
        this.neck = neck;
    }
}
