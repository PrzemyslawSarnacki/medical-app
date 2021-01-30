package wel.medicalapp.ui;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import wel.medicalapp.service.BodyFatCalc;

@Route("ui/bodyfat")
public class BodyFatCalculatorView extends VerticalLayout{
    @Autowired
    private BodyFatCalc calculator;

    public BodyFatCalculatorView() {
        Label infoLabel = new Label("Welcome in the label");
        TextField neck = new TextField("Neck:");
        TextField waist = new TextField("Waist:");
        TextField height = new TextField("Height:");
        Label label = new Label("Result");
        Select<String> gender = new Select<>();
        gender.setItems("male", "female");
        gender.setLabel("Gender");
        TextField result = new TextField("BodyFat:");
        result.setEnabled(false);
        Button calculate = new Button("Calculate");

        calculate.addClickListener((ComponentEventListener<ClickEvent<Button>>) event -> {
            try {
                String bodyfat = calculator.calculate(gender.getValue(), height.getValue(), waist.getValue(), neck.getValue());
                result.setValue(bodyfat);
            } catch (Exception e) {
                Notification notification = new Notification("Error occured");
                notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                notification.open();
            }
        });

        Button myResultsButton = new Button("Show my results");

        myResultsButton.addClickListener((ComponentEventListener<ClickEvent<Button>>) event -> {
            myResultsButton.getUI().ifPresent(ui ->
                    ui.navigate("ui/bodyfatresults"));

        });
        VerticalLayout layout = new VerticalLayout();
        layout.add(infoLabel, neck, height, label,waist, calculate, result, myResultsButton);
        layout.setHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        add(layout);


    }


}
