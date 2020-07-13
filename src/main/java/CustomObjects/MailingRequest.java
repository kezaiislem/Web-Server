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
public class MailingRequest {
    
    private String subject;
    private String text;
    private List<String> destinations;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<String> destinations) {
        this.destinations = destinations;
    }
    
}
