package dao;

import entity.Question;
import entity.Section;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository <Question,Long>{
    
    @Query("select new entity.Question (q.text) from Question q where q.section.factor.name like %?1% and q.section.survey.model.technology.technologyField.name like %?2% and q.section.survey.model.technology.technologyName like %?3% and q.section.survey.model.evaluationContext like %?4%")
    List<Question> findByFactorAndField(String factorName, String technologyField, String technologyName, String evaluationContext);
	
}
