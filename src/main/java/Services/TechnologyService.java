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
import org.springframework.stereotype.Service;

/**
 *
 * @author ISLEM
 */
@Service
@Configurable
public class TechnologyService {

    @Autowired
    TechnologyRepository technologyRepository;

    public Technology saveTechnology(Technology technology) throws Exception {
        Technology result;
        try {
            result = technologyRepository.findByName(technology.getTechnologyName()).get(0);
        } catch (Exception e) {
            technology.setId(0);
            result = technologyRepository.save(technology);
        }
        return result;
    }

}
