package dao;

import entity.Section;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {

    @Query("select new entity.Section (s.title, s.description, s.factor) from Section s where s.factor.name like %?1% and s.survey.model.technology.technologyName like %?2% and s.survey.model.technology.technologyField.name like %?3% and s.survey.model.evaluationContext like %?4%")
    List<Section> findByFactorTechnlogyNameAndField(String factorName, String technologyName, String technologyField, String evaluationContext);

}
