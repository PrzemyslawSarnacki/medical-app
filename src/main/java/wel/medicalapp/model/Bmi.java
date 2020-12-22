package wel.medicalapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bmi {
    @Id
    @GeneratedValue
    private Long id;
    private String weight;
    private String height;
    private Double bmi;

    public Bmi(){

    }

    public Bmi( String weight, String height, Double bmi) {
        this.weight = weight;
        this.height = height;
        this.bmi = bmi;
    }

    public Long getId() {
        return id;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public Double getBmi() {
        return bmi;
    }

    public void setBmi(Double bmi) {
        this.bmi = bmi;
    }
}
