/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author ISLEM
 */
@Entity
public class Host {

    @Id
    private String id;
    private Date strDate;
    private boolean online;
    @JsonIgnore
    @OneToOne(mappedBy = "host")
    private Survey survey;

    public Host() {
        this.id = UUID.randomUUID().toString();
    }

    public Host(Survey survey) {
        this.id = UUID.randomUUID().toString();
        this.survey = survey;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getStrDate() {
        return strDate;
    }

    public void setStrDate(Date strDate) {
        this.strDate = strDate;
    }

    public boolean getOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

}
