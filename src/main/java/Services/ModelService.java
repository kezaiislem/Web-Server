/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import dao.ModelRepository;
import entity.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

/**
 *
 * @author ISLEM
 */
@Service
@Configurable
public class ModelService {

    @Autowired
    ModelRepository modelRepository;
    @Autowired
    TechnologyService technologyService;

    public Model saveModel(Model model) throws Exception {
        Model result;
        try {
            result = modelRepository.findById(model.getId()).get();
        } catch (Exception e) {
            model.setTechnology(technologyService.saveTechnology(model.getTechnology()));
            result = modelRepository.save(model);
        }
        return result;
    }

}
