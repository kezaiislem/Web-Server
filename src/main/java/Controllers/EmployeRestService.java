package Controllers;

import Services.MailService;
import dao.EmployeRepository;
import entity.Employe;
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

@CrossOrigin(origins = "*")
@RestController
public class EmployeRestService {
	
	@Autowired
	EmployeRepository employeRepository;
        
        @Autowired
        MailService mailService;
	
	@GetMapping("/employeName/{nom}")
	public List<Employe> getEmployesByName(@PathVariable("nom") String nom){
		return employeRepository.findByName(nom.toLowerCase());
	}
	
	@GetMapping("/list")
	public List<Employe> getEmployes(){
		return employeRepository.findAll();
	}
	
	@GetMapping("/employe/{id}")
	public Employe getEmployee(@PathVariable("id") long id){
		return employeRepository.findById(id).get();
	}
	
	@PutMapping("/update/{id}")
	public Employe updateEmploye(@PathVariable("id") long id, @RequestBody Employe emp){
		emp.setId(id);
		/*emp.setNom(emp.getNom().toLowerCase());
		emp.setPrenom(emp.getPrenom().toLowerCase());
		emp.setAdressMail(emp.getAdressMail().toLowerCase());*/
		return employeRepository.save(emp);
	}
	
	@PostMapping("/add")
	public Employe addEmploye(@RequestBody Employe emp){
		/*emp.setNom(emp.getNom().toLowerCase());
		emp.setPrenom(emp.getPrenom().toLowerCase());
		emp.setAdressMail(emp.getAdressMail().toLowerCase());*/
		return employeRepository.save(emp);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteEmploye(@PathVariable("id") long id){
		employeRepository.deleteById(id);
	}
        
        @GetMapping("/mailer")
	public void sendMail(){
            mailService.sendSimpleMessage("kezaiislem3@gmail.com", "PFE", "Nour Ali super hatba");
	}

}
