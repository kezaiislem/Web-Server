package Controllers;

import Services.SessionService;
import dao.SessionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dao.UserRepository;
import entity.Session;
import entity.User;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin(origins = "*")
@RestController
public class UserController {

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
    
    @GetMapping("/username/{username}")
    public List<User> getUserByUserName(@PathVariable("username") String username) {
        userRepository.save(new User());
        return userRepository.findByUsername(username);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") long id) {
        return userRepository.findById(id).get();
    }
    
    @GetMapping("/chkE/{email}")
    public Boolean getUserByMail(@PathVariable("email") String email) {
        try{
            User user = userRepository.findByEmail(email).get(0);
            if(user != null){
                return true;
            }
        } catch (Exception e){
            //e.printStackTrace();
        }
        return false;
    }
    
    @GetMapping("/chkU/{username}")
    public Boolean getUserByUsername(@PathVariable("username") String username) {
        try{
            User user = userRepository.findByUsername(username).get(0);
            if(user != null){
                return true;
            }
        } catch (Exception e){
            //e.printStackTrace();
        }
        return false;
    }

    @PutMapping("/updateUser/{id}")
    public User updateEmploye(@PathVariable("id") long id, @RequestBody User user) {
        user.setId(id);
        return userRepository.save(user);
    }

    @PostMapping("/newUser")
    public Boolean addUser(@RequestBody User user) {
        try{
            user.setId((long)-1);
            User res = userRepository.save(user);
            if(res != null){
                return true;
            }
        } catch(Exception e){
            
        }
        return false;
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable("id") long id) {
        userRepository.deleteById(id);
    }

}
