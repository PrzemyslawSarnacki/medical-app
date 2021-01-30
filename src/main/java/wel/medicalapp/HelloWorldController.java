package wel.medicalapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wel.medicalapp.service.BmiCalculator;
import wel.medicalapp.service.BodyFatCalc;
import wel.medicalapp.service.PressureCalc;

@RestController
public class HelloWorldController {

    private BmiCalculator calculator;
    private PressureCalc pressureCalc;
    private BodyFatCalc bodyFatCalc;

    @Autowired
    public HelloWorldController(BmiCalculator calculator, PressureCalc pressureCalc, BodyFatCalc bodyFatCalc) {
        this.calculator = calculator;
        this.pressureCalc = pressureCalc;
        this.bodyFatCalc = bodyFatCalc;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello there";
    }

    @GetMapping("/bmi")
    public String calculateBmi(@RequestParam String weight, @RequestParam String height) {
        String bmi = calculator.calculate(weight, height);
        return "Your BMI is : " + bmi;
    }

    @GetMapping("/pressure")
    public String calculatePressure(@RequestParam String diastolic, @RequestParam String systolic) {
        String pressure = pressureCalc.pressure(diastolic, systolic);
        return "Your Pressure is : " + pressure;
    }

    @GetMapping("/bodyfat")
    public String calculateBodyFat(@RequestParam String gender, @RequestParam String waist, @RequestParam String neck, @RequestParam String height) {
        String pressure = bodyFatCalc.calculate(gender, waist, neck, height);
        return "Your BodyFat level is : " + pressure + "%";
    }

}
