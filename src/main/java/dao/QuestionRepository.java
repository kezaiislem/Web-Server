package dao;

import entity.Question;
import entity.Factor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository <Question,Long>{
    
    @Query("select new entity.Question (q.text) from Question q where q.factor.title like %?1% and q.factor.survey.model.technology.technologyField.name like %?2% and q.factor.survey.model.technology.technologyName like %?3% and q.factor.survey.model.evaluationContext like %?4%")
    List<Question> findByFactorAndField(String factorName, String technologyField, String technologyName, String evaluationContext);
	
}
