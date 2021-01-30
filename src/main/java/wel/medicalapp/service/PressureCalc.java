package wel.medicalapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wel.medicalapp.model.BodyFat;
import wel.medicalapp.model.Pressure;
import wel.medicalapp.repository.PressureRepository;

import java.util.List;

@Service
public class PressureCalc {

    private PressureRepository pressureRepository;

    @Autowired
    public PressureCalc(PressureRepository pressureRepository) {
        this.pressureRepository = pressureRepository;
    }

    public String pressure(String diastolic, String systolic) {

        double d = Double.valueOf(diastolic);
        double s = Double.valueOf(systolic);
        String pressure;

        if (s < 120 && d < 80) {
            pressure = "Optimal";
        } else if (s > 120 || s < 129 && d > 80 || d < 84) {
            pressure = "Normal";
        } else if (s > 130 || s < 139 && d > 85 || d < 89) {
            pressure = "High Normal";
        }
        else {
            pressure = "Not classified";
        }


        Pressure entity = new Pressure(systolic, diastolic, pressure);
        pressureRepository.save(entity);
        return pressure;
    }

    public List<Pressure> getAllResults() {

        return pressureRepository.findAll();
    }

}
