/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import dao.HostRepository;
import entity.Host;
import entity.Model;
import entity.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

/**
 *
 * @author ISLEM
 */
@Service
@Configurable
public class HostService {

    @Autowired
    HostRepository hostRepository;
    @Autowired
    SurveyService surveyService;
    @Autowired
    ModelService modelService;

    public Host hostSurvey(Survey survey) throws Exception {
        Model model = modelService.saveModel(survey.getModel());
        if (model.getSurveys() != null) {
            for (Survey s : model.getSurveys()) {
                if (s.getPhaseNumber() == survey.getPhaseNumber()) {
                    return null;
                }
            }
        }
        Host host = new Host();
        hostRepository.save(host);
        survey.setHost(host);
        survey.setModel(model);
        host.setSurvey(null);
        host.setSurvey(surveyService.postSurvey(survey));
        return host;
    }

    public Host getHost(String id) throws Exception {
        return hostRepository.findById(id).get();
    }
    
    public Host switchStatus(String id){
        try {
            Host host = hostRepository.findById(id).get();
            host.setOnline(!host.getOnline());
            return hostRepository.save(host);
        } catch (Exception e){
            throw e;
        }
    }

}
