package wel.medicalapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wel.medicalapp.service.BmiCalculator;
import wel.medicalapp.service.PressureCalc;

@RestController
public class HelloWorldController {

    private BmiCalculator calculator;
    private PressureCalc pressureCalc;

    @Autowired
    public HelloWorldController(BmiCalculator calculator, PressureCalc pressureCalc) {
        this.calculator = calculator;
        this.pressureCalc = pressureCalc;
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

}
