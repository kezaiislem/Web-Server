/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import CustomObjects.AnswerPostObject;
import CustomObjects.AnswersPostObject;
import dao.AnswerRepository;
import dao.PersonalAnswerRepository;
import entity.Answer;
import entity.PersonalAnswer;
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
    @Autowired
    PersonalAnswerRepository personalAnswerRepository;
 
    public List<Answer> postAnswers(AnswersPostObject answersPost) throws Exception{
        PersonalAnswer personalAnswer = new PersonalAnswer(answersPost.getSurveyId());
        personalAnswer = personalAnswerRepository.save(personalAnswer);
        List<Answer> answers = new ArrayList<>();
        for(AnswerPostObject answerPost : answersPost.getAnswers()){
            answers.add(new Answer(answerPost, personalAnswer));
        }
        return answerRepository.saveAll(answers);
    }

}
