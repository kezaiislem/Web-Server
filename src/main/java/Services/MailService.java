/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import dao.TechnologyRepository;
import entity.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 *
 * @author ISLEM
 */
@Service
@Configurable
public class MailService {

    @Autowired
    JavaMailSender emailSender;

    public void sendSimpleMessage(String to, String subject, String text) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("emailsender");
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);
            emailSender.send(message);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
