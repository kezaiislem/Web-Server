/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import dao.SurveyRepository;
import entity.Factor;
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
 
    public Survey postSurvey(Survey survey) throws Exception{
        List<Factor> factors = survey.getFactors();
        survey.setFactors(null);
        
        Survey result = surveyRepository.save(survey);
        result.setFactors(sectionService.postSections(factors, result));
        
        return result;
    }
    
    public void delete(long id) throws Exception{
        surveyRepository.deleteById(id);
    }
    
    public Survey get(long id) throws Exception{
        return surveyRepository.findById(id).get();
    }

}
