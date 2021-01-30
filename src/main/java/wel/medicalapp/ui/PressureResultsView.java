package wel.medicalapp.ui;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import wel.medicalapp.model.BodyFat;
import wel.medicalapp.model.Pressure;
import wel.medicalapp.service.BodyFatCalc;
import wel.medicalapp.service.PressureCalc;

import javax.annotation.PostConstruct;
import java.util.List;

@Route("ui/pressureresults")
public class PressureResultsView extends VerticalLayout {
    private final Grid<Pressure> grid = new Grid<>(Pressure.class);

    @Autowired
    private PressureCalc calculator;

    public PressureResultsView() {
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
        List<Pressure> allResults = calculator.getAllResults();
        grid.setDataProvider(new ListDataProvider<>(allResults));
    }

}

