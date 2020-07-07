/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomObjects;

import entity.Survey;
import entity.Technology;

/**
 *
 * @author ISLEM
 */
public class CustomHostObject {
    
    private Survey survey;
    private Technology technology;

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public Technology getTechnology() {
        return technology;
    }

    public void setTechnology(Technology technology) {
        this.technology = technology;
    }
    
    
    
}
