package wel.medicalapp.ui;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import wel.medicalapp.service.BmiCalculator;


@Route("ui/bmi")
public class BmiCalculatorView extends VerticalLayout {
    @Autowired
    private BmiCalculator calculator;

    public BmiCalculatorView() {
        Label infoLabel = new Label("Welcome in the label");
        TextField weight = new TextField("Weight:");
        TextField height = new TextField("Height:");
        Label label = new Label("Result");
        TextField result = new TextField("BMI:");
        result.setEnabled(false);
        Button calculate = new Button("Calculate");
        VerticalLayout layout = new VerticalLayout();
        calculate.addClickListener((ComponentEventListener<ClickEvent<Button>>) event -> {
            try {
                String bmi = calculator.calculate(weight.getValue(), height.getValue());
                result.setValue(bmi);
            } catch (Exception e) {
                Notification notification = new Notification("Error occured");
                notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                notification.open();
            }
        });
        Button myResultsButton = new Button("Show my results");
        myResultsButton.addClickListener((ComponentEventListener<ClickEvent<Button>>) event -> {
            myResultsButton.getUI().ifPresent(ui ->
                    ui.navigate("ui/bmiresults"));

        });
        layout.add(infoLabel, weight, height, label, calculate, result, myResultsButton);
        layout.setHorizontalComponentAlignment(Alignment.CENTER);
        layout.setAlignItems(Alignment.CENTER);
        add(layout);


    }

}
