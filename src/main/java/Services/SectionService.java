/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import dao.FactorRepository;
import dao.SectionRepository;
import entity.Question;
import entity.Section;
import entity.Survey;
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
public class SectionService {

    @Autowired
    SectionRepository sectionRepository;
    @Autowired
    QuestionService questionService;
    @Autowired
    FactorRepository factorRepository;

    public List<Section> postSections(List<Section> sections, Survey survey) throws Exception {

        List<Section> result = new ArrayList<>();
        
        for (Section c : sections) { 
            //c.setFactor(factorRepository.findById(c.getFactor().getId()).get());
            List<Question> questions = c.getQuestions();
            c.questions = null;
            c.setSurvey(survey);
            Section section = sectionRepository.save(c);
            for (Question q : questions) {
                q.setSection(section);
            }
            section.setQuestions(questionService.postQuestions(questions));
            result.add(section);
        }
        
        return result;
    }
    
    public List<Section> searchSections(String factorName, String technologyName, String technologyField, String evaluationContext){
        try {
            System.out.println(factorName+" "+technologyField+" "+technologyName);
            return sectionRepository.findByFactorTechnlogyNameAndField(factorName, technologyName, technologyField, evaluationContext);
        } catch (Exception e){
            e.printStackTrace();
            return new ArrayList<Section>();
        }
    }

}
