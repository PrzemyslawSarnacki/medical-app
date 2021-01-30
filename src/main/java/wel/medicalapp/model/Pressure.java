package wel.medicalapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pressure {
    @Id
    @GeneratedValue
    private Long id;
    private String systolic;
    private String diastolic;
    private String pressure;

    public Pressure() {
    }

    public Pressure(String systolic, String diastolic, String pressure) {
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.pressure = pressure;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSystolic() {
        return systolic;
    }

    public void setSystolic(String systolic) {
        this.systolic = systolic;
    }

    public String getDiastolic() {
        return diastolic;
    }

    public void setDiastolic(String diastolic) {
        this.diastolic = diastolic;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }
}
