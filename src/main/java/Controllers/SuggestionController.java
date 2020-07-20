package Controllers;

import Services.QuestionService;
import Services.FactorService;
import entity.Question;
import entity.Factor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class SuggestionController {

    @Autowired
    FactorService factorService;
    @Autowired
    QuestionService questionService;

    @GetMapping("/factorsuggestions")
    public List<Factor> getSections(@RequestParam("technologyname") String technologyName, @RequestParam("technologyfield") String technologyField, @RequestParam("evaluationContext") String evaluationContext, @RequestParam("factorname") String factorName) {
        return (List<Factor>) factorService.searchSections(factorName, technologyName, technologyField, evaluationContext);
    }

    @GetMapping("/questionsuggestions")
    public List<Question> getQuestions(@RequestParam("technologyname") String technologyName, @RequestParam("technologyfield") String technologyField, @RequestParam("evaluationContext") String evaluationContext, @RequestParam("factorname") String factorName) {
        return questionService.searchQuestions(factorName, technologyField, technologyName, evaluationContext);
    }

}
