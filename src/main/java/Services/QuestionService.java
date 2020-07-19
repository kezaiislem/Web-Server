/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import dao.QuestionRepository;
import entity.Question;
import entity.Factor;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

/**
 *
 * @author ISLEM
 */
@Service
@Configurable
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public List<Question> postQuestions(List<Question> questions) throws Exception {
        List<Question> result = (List<Question>) questionRepository.saveAll(questions);
        for(Question q : result){
            q.setAnswers(null);
        }
        return (List<Question>) result;
    }
    
    public List<Question> searchQuestions(String factorName, String technologyField, String technologyName, String evaluationContext){
        try {
            return questionRepository.findByFactorAndField(factorName, technologyField, technologyName, evaluationContext);
        } catch (Exception e){
            e.printStackTrace();
            return new ArrayList<Question>();
        }
    }

}
