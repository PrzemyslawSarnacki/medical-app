package wel.medicalapp.ui;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import wel.medicalapp.model.Bmi;
import wel.medicalapp.model.BodyFat;
import wel.medicalapp.service.BmiCalculator;
import wel.medicalapp.service.BodyFatCalc;

import javax.annotation.PostConstruct;
import java.util.List;

@Route("ui/bodyfatresults")
public class BodyFatResultsView extends VerticalLayout {
    private final Grid<BodyFat> grid = new Grid<>(BodyFat.class);

    @Autowired
    private BodyFatCalc calculator;

    public BodyFatResultsView() {
        setMargin(true);
        setSizeFull();

        grid.setSizeFull();
        grid.setColumnReorderingAllowed(true);

        add(grid);

        setHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
        setAlignItems(FlexComponent.Alignment.CENTER);
        add(grid);

    }

    @PostConstruct
    public void init() {
        List<BodyFat> allResults = calculator.getAllResults();
        grid.setDataProvider(new ListDataProvider<>(allResults));
    }

}

