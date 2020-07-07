/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import dao.FactorRepository;
import dao.QuestionRepository;
import dao.SectionRepository;
import dao.SurveyRepository;
import entity.Factor;
import entity.Question;
import entity.Section;
import entity.Survey;
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
public class SurveyService {

    @Autowired
    SurveyRepository surveyRepository;
    @Autowired
    SectionService sectionService;
    @Autowired
    FactorRepository factorRepository;
 
    public Survey postSurvey(Survey survey) throws Exception{
        List<Section> sections = survey.getSections();
        survey.setSections(null);
        
        Survey result = surveyRepository.save(survey);
        result.setSections(sectionService.postSections(sections, result));
        
        return result;
    }

}
