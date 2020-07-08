package Controllers;

import Services.ModelService;
import Services.QuestionService;
import Services.SectionService;
import entity.Model;
import entity.Question;
import entity.Section;
import entity.Survey;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class SurveyConrtoller {

    @Autowired
    ModelService modelService;

    @GetMapping("/modelSurveys/{id}")
    public List<Survey> getHostedSurveys(@PathVariable("id") int id) {
        List<Survey> result;
        try {
            Model model = modelService.getSurveysByModel(id);
            result = model.getSurveys();
            for(Survey s : result){
                s.setSections(null);
            }
            return result;
        } catch (Exception e) {
            return new ArrayList<Survey>();
        }
    }

}
