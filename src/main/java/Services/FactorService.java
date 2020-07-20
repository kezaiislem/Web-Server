/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import entity.Question;
import entity.Factor;
import entity.Survey;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import dao.FactorRepository;

/**
 *
 * @author ISLEM
 */
@Service
@Configurable
public class FactorService {

    @Autowired
    FactorRepository sectionRepository;
    @Autowired
    QuestionService questionService;

    public List<Factor> postSections(List<Factor> factors, Survey survey) throws Exception {

        List<Factor> result = new ArrayList<>();
        
        for (Factor c : factors) { 
            List<Question> questions = c.getQuestions();
            c.questions = null;
            c.setSurvey(survey);
            Factor section = sectionRepository.save(c);
            for (Question q : questions) {
                q.setFactor(section);
            }
            section.setQuestions(questionService.postQuestions(questions));
            result.add(section);
        }
        
        return result;
    }
    
    public List<Factor> searchSections(String factorName, String technologyName, String technologyField, String evaluationContext){
        try {
            List<Factor> factors = sectionRepository.findByFactorTechnlogyNameAndField(factorName, technologyName, technologyField, evaluationContext);
            for(Factor f : factors){
                for(Question q : f.questions){
                    q.setAnswers(null);
                }
            }
            return factors;
        } catch (Exception e){
            e.printStackTrace();
            return new ArrayList<Factor>();
        }
    }

}
