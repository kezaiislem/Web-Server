/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Services.FactorService;
import entity.Factor;
import entity.Host;
import entity.Section;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ISLEM
 */
@CrossOrigin(origins = "*")
@RestController
public class FactorController {

    @Autowired
    FactorService factorService;

    @GetMapping("/factors")
    public List<Factor> getFactors() {
        try {
            return factorService.getFactors();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @GetMapping("/foctorQuestions")
    public List<Section> getSections() { 
        try {
            return factorService.getFactors().get(0).getSections();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
