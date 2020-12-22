package wel.medicalapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wel.medicalapp.model.Bmi;
import wel.medicalapp.repository.BmiRepository;

@Service
public class BmiCalculator {

    private BmiRepository bmiRepository;

    @Autowired
    public BmiCalculator(BmiRepository bmiRepository) {
        this.bmiRepository = bmiRepository;
    }

    public String calculate(String weight, String height) {

        double w = Double.valueOf(weight);
        double h = Double.valueOf(height);

        double bmi = w / Math.pow(h, 2);

        Bmi entity = new Bmi(weight, height, bmi);
        bmiRepository.save(entity);

        return String.valueOf(bmi);
    }
}
