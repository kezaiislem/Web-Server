/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomObjects;

import entity.Survey;
import java.util.List;

/**
 *
 * @author ISLEM
 */
public class CustomSurveysObject {
    
    private Survey survey;
    private int answersCount;

    public CustomSurveysObject(Survey survey) {
        this.survey = survey;
        this.answersCount = survey.getPersonalAnswers().size();
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public int getAnswersCount() {
        return answersCount;
    }

    public void setAnswersCount(int answersCount) {
        this.answersCount = answersCount;
    }
    
}
