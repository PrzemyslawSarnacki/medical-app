package wel.medicalapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wel.medicalapp.model.Bmi;

@Repository
public interface BmiRepository extends JpaRepository<Bmi, Long> {

}
