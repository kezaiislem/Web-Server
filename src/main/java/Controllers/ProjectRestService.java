package Controllers;

import Services.SessionService;
import dao.ProjectRepository;
import entity.Employe;
import entity.User;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class ProjectRestService {

    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    SessionService sessionService;

    /*@PostMapping("/newproject")
    public Project addProject(@RequestParam("sessionid") String sessionId, @RequestBody Project project) {
        User user = sessionService.isAlive(sessionId);
        Project result = null;
        if (user == null) {
            return null;
        }
        project.setUser(user);
        result = projectRepository.save(project);
        result.setUser(null);
        return result;
    }

    @GetMapping("/projectList")
    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    @DeleteMapping("/deleteproject/{id}")
    public void deleteEmploye(@PathVariable("id") long id) {
        projectRepository.deleteById(id);
    }*/

}
