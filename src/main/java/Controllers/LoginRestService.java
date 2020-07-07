/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Services.SessionService;
import dao.SessionRepository;
import dao.UserRepository;
import entity.Session;
import entity.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ISLEM
 */
@CrossOrigin(origins = "*")
@RestController
public class LoginRestService {
    
    @Autowired
    UserRepository userRepository;
    @Autowired
    SessionRepository sessionRepository;
    @Autowired
    SessionService sessionService;

    @GetMapping("/authenticate")
    public Session authenticate(@RequestParam("user") String username, @RequestParam("pass") String password) {
        List<User> users = userRepository.findByUsername(username);
        if(users.size() > 0){
            User user = users.get(0);
            if(user.getPassword().equals(password)){
                try {
                    Session result = sessionRepository.save(new Session(user));
                    result.getUser().setPassword(null);
                    //result.getUser().setProjects(null);
                    return result;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
