package dao;

import entity.Factor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FactorRepository extends JpaRepository<Factor, Long> {

    @Query("select f from Factor f where f.title like %?1% and f.title not like 'None' and f.survey.model.technology.technologyName like %?2% and f.survey.model.technology.technologyField.name like %?3% and f.survey.model.evaluationContext like %?4%")
    List<Factor> findByFactorTechnlogyNameAndField(String factorName, String technologyName, String technologyField, String evaluationContext);

}
