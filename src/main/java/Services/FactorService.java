/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import dao.FactorRepository;
import dao.QuestionRepository;
import entity.Factor;
import entity.Question;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

/**
 *
 * @author ISLEM
 */
@Service
@Configurable
public class FactorService {

    @Autowired
    FactorRepository factorRepository;

    public List<Factor> getFactors() throws Exception {
        return factorRepository.findAll();
    }

}
