/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import CustomObjects.AnswersPostObject;
import CustomObjects.CustomHostObject;
import Services.AnswerService;
import Services.HostService;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Answer;
import entity.Host;
import entity.Survey;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ISLEM
 */
@CrossOrigin(origins = "*")
@RestController
public class HostController {

    @Autowired
    HostService hostService;
    @Autowired
    AnswerService asnwerService;

    @PostMapping("/host")
    public Survey hostSurvey(@RequestBody Survey survey) {
        try {
            if (survey != null) {
                Host result = hostService.hostSurvey(survey);
                if (result == null) {
                    return null;
                }
                /*ObjectMapper mapper = new ObjectMapper();
                String json = mapper.writeValueAsString(result);*/
                return result.getSurvey();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    @GetMapping("/survey/{id}")
    public Survey getSurvey(@PathVariable("id") String id) {
        try {
            Survey result = hostService.getHost(id).getSurvey();
            result.setAnswers(null);
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/postAnswer")
    public String postAnswer(@RequestBody AnswersPostObject answers) throws Exception {
        asnwerService.postAnswers(answers);
        return "";
    }
    
    @PutMapping("/switchStatus/{id}")
    public Host switchStatus(@PathVariable("id") String id){
        try{
            return hostService.switchStatus(id);
        } catch (Exception e){
        }
        return null;
    }

}
