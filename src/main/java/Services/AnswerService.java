/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import CustomObjects.AnswerPostObject;
import CustomObjects.AnswersPostObject;
import dao.AnswerRepository;
import dao.FactorRepository;
import dao.QuestionRepository;
import dao.SectionRepository;
import dao.SurveyRepository;
import entity.Answer;
import entity.Factor;
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
public class AnswerService {

    @Autowired
    AnswerRepository answerRepository;
 
    public List<Answer> postAnswers(AnswersPostObject answersPost) throws Exception{
        List<Answer> answers = new ArrayList<>();
        for(AnswerPostObject answerPost : answersPost.getAnswers()){
            answers.add(new Answer(answerPost, answersPost.getSurveyId()));
        }
        return answerRepository.saveAll(answers);
    }

}
