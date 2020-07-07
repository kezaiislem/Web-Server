/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomObjects;

import java.util.List;

/**
 *
 * @author ISLEM
 */
public class AnswersPostObject {
    
    private long surveyId;
    private List<AnswerPostObject> answers;

    public long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(long surveyId) {
        this.surveyId = surveyId;
    }

    public List<AnswerPostObject> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerPostObject> answers) {
        this.answers = answers;
    }
    
}
