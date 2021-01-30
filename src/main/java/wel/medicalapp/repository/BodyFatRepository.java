package wel.medicalapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wel.medicalapp.model.BodyFat;
import wel.medicalapp.model.Pressure;

@Repository
public interface BodyFatRepository extends JpaRepository<BodyFat, Long>{

}
