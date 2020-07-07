package Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import entity.Field;
import dao.FieldRepository;

@CrossOrigin(origins = "*")
@RestController
public class DomainRestService {

    @Autowired
    FieldRepository domainRepository;

    @GetMapping("/domains")
    public List<Field> getDomains() {
        List<Field> result = domainRepository.findAll();
        return result;
    }

}
