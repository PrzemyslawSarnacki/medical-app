package wel.medicalapp.ui;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import wel.medicalapp.service.PressureCalc;

@Route("ui/pressure")
public class PressureCalculatorView extends VerticalLayout {

    @Autowired
    private PressureCalc calculator;

    public PressureCalculatorView() {
        Label infoLabel = new Label("Welcome in the label");
        TextField systolic = new TextField("Systolic:");
        TextField diastolic = new TextField("Diastolic:");
        Label label = new Label("Result");
        TextField result = new TextField("Pressure:");
        result.setEnabled(false);
        Button calculate = new Button("Calculate");

        calculate.addClickListener((ComponentEventListener<ClickEvent<Button>>) event -> {
            try {
                String pressure = calculator.pressure(diastolic.getValue(), systolic.getValue());
                result.setValue(pressure);
            } catch (Exception e) {
                Notification notification = new Notification("Error occured");
                notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                notification.open();
            }
        });

        Button myResultsButton = new Button("Show my results");

        myResultsButton.addClickListener((ComponentEventListener<ClickEvent<Button>>) event -> {
            myResultsButton.getUI().ifPresent(ui ->
                    ui.navigate("ui/pressureresults"));

        });
        VerticalLayout layout = new VerticalLayout();
        layout.add(infoLabel, diastolic, systolic, calculate, result, myResultsButton);
        layout.setHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        add(layout);
    }
}
