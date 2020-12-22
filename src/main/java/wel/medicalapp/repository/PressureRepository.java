package wel.medicalapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wel.medicalapp.model.Pressure;

@Repository
public interface PressureRepository extends JpaRepository<Pressure, Long> {

}
