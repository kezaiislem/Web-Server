/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Utils.DateUtils;
import dao.SessionRepository;
import entity.Session;
import entity.User;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

/**
 *
 * @author ISLEM
 */
@Service
@Configurable
public class SessionService {
    
    @Autowired
    SessionRepository sessionRepositoty;
    
    public User isAlive(String sessionid){
        try{
            Session s = sessionRepositoty.getOne(sessionid);
            if(s.getExpDate().after(new Date())){
                return s.getUser();
            }
        } catch (Exception e){
            
        }
        return null;
    }
    
}
