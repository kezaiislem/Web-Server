/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomObjects;

import entity.Answer;
import entity.PersonalAnswer;
import entity.Question;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ISLEM
 */
public class CustomPersonalAnswer {
    
    private List<Answer> answers;
    private List<Question> questions;

    public CustomPersonalAnswer(PersonalAnswer personalAnswer) {
        this.answers = personalAnswer.getAnswers();
        this.questions = new ArrayList<>();
        for(Answer answer : this.answers){
            this.questions.add(new Question(answer.getQuestion().getText(), answer.getQuestion().getType(), answer.getQuestion().getChoices()));
        }
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
