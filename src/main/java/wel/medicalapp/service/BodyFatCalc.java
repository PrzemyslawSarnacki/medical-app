package wel.medicalapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wel.medicalapp.model.Bmi;
import wel.medicalapp.model.BodyFat;
import wel.medicalapp.repository.BmiRepository;
import wel.medicalapp.repository.BodyFatRepository;

import java.util.List;

import static java.lang.Math.log;

@Service
public class BodyFatCalc {
    private BodyFatRepository bodyFatRepository;

    @Autowired
    public BodyFatCalc(BodyFatRepository bodyFatRepository) {
        this.bodyFatRepository = bodyFatRepository;
    }

    public String calculate(String gender, String height, String waist, String neck) {

        double h = Double.valueOf(height);
        double w = Double.valueOf(waist);
        double n = Double.valueOf(neck);
        double result = 0;

        if ((gender == "male") && ((h > 0) && (w > 0) && (n > 0))) {
            result = ((495) /
                    (1.0324 -
                            (0.19077 * (log(w - n) / 2.303)) +
                            (0.15456 * log(h) / 2.303))) -
                    450;
        } else if ((gender == "female") &&
                ((h > 0) && (w > 0) && (n > 0))) {
            result = ((495) /
                    (1.29579 -
                            (0.35004 * (log(w - n) / 2.303)) +
                            (0.22100 * log(h) / 2.303))) -
                    450;
        } else {
            System.out.println("Error");
        }


        BodyFat entity = new BodyFat(gender, height, waist, neck, result);
        bodyFatRepository.save(entity);

        return String.valueOf(result);
    }

    public List<BodyFat> getAllResults() {

        return bodyFatRepository.findAll();
    }

}
