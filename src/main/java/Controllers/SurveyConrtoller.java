package Controllers;

import CustomObjects.CustomSurveysObject;
import Services.ModelService;
import Services.SurveyService;
import entity.Answer;
import entity.Model;
import entity.PersonalAnswer;
import entity.Factor;
import entity.Survey;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class SurveyConrtoller {

    @Autowired
    ModelService modelService;

    @Autowired
    SurveyService surveyService;

    @GetMapping("/modelSurveys/{id}")
    public List<CustomSurveysObject> getHostedSurveys(@PathVariable("id") int id) {
        List<Survey> surveys;
        List<CustomSurveysObject> result = new ArrayList<>();
        try {
            Model model = modelService.getSurveysByModel(id);
            surveys = model.getSurveys();
            for (Survey s : surveys) {
                s.setFactors(null);
                result.add(new CustomSurveysObject(s));
            }
            return result;
        } catch (Exception e) {
            return result;
        }
    }
    
    @GetMapping("/answers/{id}")
    public List<Factor> getSurveyAnswers(@PathVariable("id") int id) {
        List<Factor> result = null;
        try {
            Survey survey = surveyService.get(id);
            result = survey.getFactors();
            return result;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @DeleteMapping("/deleteSurvey/{id}")
    public void deleteSurvey(@PathVariable("id") long id) throws Exception {
        surveyService.delete(id);
    }

}
