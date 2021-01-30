package wel.medicalapp.ui;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import wel.medicalapp.service.BmiCalculator;
import wel.medicalapp.service.BodyFatCalc;

@Route("ui/bodyfat")
public class BodyFatCalculatorView {
    @Autowired
    private BodyFatCalc calculator;

    public BodyFatCalculatorView() {
        TextField weight = new TextField("Weight:");
        Label infoLabel = new Label("Welcome in the label");
        TextField height = new TextField("Height:");
        Label label = new Label("Result");
        Select<String> labelSelect = new Select<>();
        labelSelect.setItems("male", "female");
        labelSelect.setLabel("Gender");
        TextField result = new TextField("BodyFat:");
        result.setEnabled(false);
        Button calculate = new Button("Calculate");

        calculate.addClickListener((ComponentEventListener<ClickEvent<Button>>) event -> {
            try {
                String bodyfat = calculator.calculate(weight.getValue(), height.getValue());
                result.setValue(bmi);
            } catch (Exception e) {
                Notification notification = new Notification("Error occured");
                notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                notification.open();
            }
        });


    }


}
