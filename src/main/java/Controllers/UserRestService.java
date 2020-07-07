package Controllers;

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
import entity.User;

@CrossOrigin(origins = "*")
@RestController
public class UserRestService {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/username/{username}")
    public List<User> getEmployesByName(@PathVariable("username") String username) {
        userRepository.save(new User());
        return userRepository.findByUsername(username);
    }

    @GetMapping("/users")
    public List<User> getEmployes() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public User getEmployee(@PathVariable("id") long id) {
        return userRepository.findById(id).get();
    }

    @PutMapping("/updateUser/{id}")
    public User updateEmploye(@PathVariable("id") long id, @RequestBody User user) {
        user.setId(id);
        return userRepository.save(user);
    }

    @PostMapping("/addUser")
    public User addEmploye(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable("id") long id) {
        userRepository.deleteById(id);
    }

}
